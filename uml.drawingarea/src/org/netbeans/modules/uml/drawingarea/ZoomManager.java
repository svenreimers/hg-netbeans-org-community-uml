/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright 1997-2010 Oracle and/or its affiliates. All rights reserved.
 *
 * Oracle and Java are registered trademarks of Oracle and/or its affiliates.
 * Other names may be trademarks of their respective owners.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common
 * Development and Distribution License("CDDL") (collectively, the
 * "License"). You may not use this file except in compliance with the
 * License. You can obtain a copy of the License at
 * http://www.netbeans.org/cddl-gplv2.html
 * or nbbuild/licenses/CDDL-GPL-2-CP. See the License for the
 * specific language governing permissions and limitations under the
 * License.  When distributing the software, include this License Header
 * Notice in each file and include the License file at
 * nbbuild/licenses/CDDL-GPL-2-CP.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the GPL Version 2 section of the License file that
 * accompanied this code. If applicable, add the following below the
 * License Header, with the fields enclosed by brackets [] replaced by
 * your own identifying information:
 * "Portions Copyrighted [year] [name of copyright owner]"
 *
 * Contributor(s):
 *
 * The Original Software is NetBeans. The Initial Developer of the Original
 * Software is Sun Microsystems, Inc. Portions Copyright 1997-2007 Sun
 * Microsystems, Inc. All Rights Reserved.
 *
 * If you wish your version of this file to be governed by only the CDDL
 * or only the GPL Version 2, indicate your decision by adding
 * "[Contributor] elects to include this software in this distribution
 * under the [CDDL or GPL Version 2] license." If you do not indicate a
 * single choice of license, a recipient has the option to distribute
 * your version of this file under either the CDDL, the GPL Version 2 or
 * to extend the choice of license to its licensees as provided above.
 * However, if you add GPL Version 2 code and therefore, elected the GPL
 * Version 2 license, then the option applies only if the new code is
 * made subject to such option by the copyright holder.
 */
package org.netbeans.modules.uml.drawingarea;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.EventListener;
import java.util.EventObject;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.JViewport;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.event.EventListenerList;
import org.netbeans.api.visual.widget.Scene;
import org.netbeans.api.visual.widget.Widget;
import org.netbeans.modules.uml.drawingarea.keymap.DiagramInputkeyMapper;
import org.netbeans.modules.uml.resources.images.ImageUtil;
import org.openide.util.ImageUtilities;
import org.openide.util.NbBundle;
import org.netbeans.modules.uml.drawingarea.view.DesignerScene;
import org.netbeans.modules.uml.drawingarea.view.DesignerTools;
import org.openide.util.Utilities;



public class ZoomManager implements Scene.SceneListener {

    /** The default zoom percent value. */
    public static final int DEFAULT_ZOOM_PERCENT = 100;
    /** The minimum zoom percent value. */
    public static final int MIN_ZOOM_PERCENT = 1;
    /** The maximum zoom percent value. */
    public static final int MAX_ZOOM_PERCENT = 1600;
    
/** Point at which the zoom increments/decrements more or less
     * (less below the threshold, more above the threshold). */
    private static final int ZOOM_STEP_THRESHOLD = DEFAULT_ZOOM_PERCENT;
    /** Small zoom increment, when below the threshold. */
    private static final int ZOOM_STEP_SMALL = 5;
    /** Large zoom increment, when above the threshold. */
    private static final int ZOOM_STEP_LARGE = 25;
    /** The scene to zoom in/out. */
    private Scene scene;
    /** The zoom factor in the form of a percentage (e.g. 75%). */
    private int zoomPercentage = DEFAULT_ZOOM_PERCENT;
    /** List of zoom listeners. */
    private EventListenerList listeners;
    private int lastZoomLevel;
    private Cursor zoomCursor;
    private Cursor zoomStopCursor;

    
/**
     * Creates a new instance of ZoomManager.
     *
     * @param  scene  the scene to be managed.
     */
    public ZoomManager(final Scene scene) {
        this.scene = scene;
        scene.addSceneListener(this);
        listeners = new EventListenerList();
    }

    
/**
     * Adds the given listener to this manager instance. It will be notified
     * when the zoom value is changed.
     *
     * @param  listener  listener to be added.
     */
    public void addZoomListener(ZoomListener listener) {
        listeners.add(ZoomListener.class, listener);
    }

    
/**
     * Adds zoom actions to the given toolbar (no separators are added).
     *
     * @param  toolbar  to which the actions are added.
     */
    public void addToolbarActions(JToolBar toolbar) {
        toolbar.add(new FitDiagramAction(this));
        toolbar.add(new FitWidthAction(this));
        toolbar.add(new ZoomDefaultAction(this));
        toolbar.add(new ZoomComboBox(this));
        ZoomInAction inAction = new ZoomInAction(this);
        addZoomListener(inAction);
        toolbar.add(inAction);
        ZoomOutAction outAction = new ZoomOutAction(this);
        addZoomListener(outAction);
        toolbar.add(outAction);
    }

    
/**
     * Determine the zoom percentage if the user is zooming in
     * (e.g. from 75 to 80, 100 to 125, etc.).
     *
     * @param  percent  the current percent value.
     * @return  the decreased percent value.
     */
    public static int calculateZoomInValue(int percent) {
        int newZoomValue;
        if (percent >= ZOOM_STEP_THRESHOLD) {
            newZoomValue = ((percent + ZOOM_STEP_LARGE) / ZOOM_STEP_LARGE) * ZOOM_STEP_LARGE;
        } else {
            newZoomValue = ((percent + ZOOM_STEP_SMALL) / ZOOM_STEP_SMALL) * ZOOM_STEP_SMALL;
        }
        return newZoomValue;
    }

    
/**
     * Determine the zoom percentage if the user is zooming out
     * (e.g. from 75 to 70, 150 to 125, etc.).
     *
     * @param  percent  the current percent value.
     * @return  the increased percent value.
     */
    public static int calculateZoomOutValue(int percent) {
        int newZoomValue;
        if (percent > ZOOM_STEP_THRESHOLD) {
            newZoomValue = ((percent - 1) / ZOOM_STEP_LARGE) * ZOOM_STEP_LARGE;
        } else {
            newZoomValue = ((percent - 1) / ZOOM_STEP_SMALL) * ZOOM_STEP_SMALL;
        }
        return newZoomValue;
    }

    
/**
     * Fires zoom events to the registered listeners, if any.
     *
     * @param  percent  the new percent value.
     */
    private void fireZoomEvent(int percent) {
        if (percent != lastZoomLevel) {
            lastZoomLevel = percent;
            // update variable zoompercent
            zoomPercentage = percent;
            Object[] list = listeners.getListenerList();
            ZoomEvent event = null;
            for (int ii = list.length - 2; ii >= 0; ii -= 2) {
                if (list[ii] == ZoomListener.class) {
                    if (event == null) {
                        event = new ZoomEvent(this, percent);
                    }
                    ((ZoomListener) list[ii + 1]).zoomChanged(event);
                }
            }
        }
    }

    
/**
     * Return the Scene for which this manager is controlling the zoom.
     *
     * @return  Scene managed by this manager.
     */
    public Scene getScene() {
        return scene;
    }

    
/**
     * Return the zoom factor for the Scene mananged by this ZoomManager
     * instance. The value represents a percentage (e.g. 100%) and
     * is always a positive number.
     *
     * @return  current zoom percentage.
     */
    public int getZoom() {
        return zoomPercentage;
    }

    
/**
     * Removes the given listener from this manager instance, such that it
     * will no longer receive zoom events.
     *
     * @param  listener  listener to be removed.
     */
    public void removeZoomListener(ZoomListener listener) {
        listeners.remove(ZoomListener.class, listener);
    }

    
/**
     * Set the zoom factor for the Scene mananged by this ZoomManager
     * instance. The value represents a percentage (e.g. 100%) and
     * must be a positive number. Any value outside of the defined
     * range (<tt>MIN_ZOOM_PERCENT</tt> and <tt>MAX_ZOOM_PERCENT</tt>)
     * will be forced into that range.
     *
     * @param  percent  the percent value (e.g. 50 for half-size,
     *                  200 for double-size).
     */
    public void setZoom(int percent) {
        JScrollPane pane = (JScrollPane) SwingUtilities.getAncestorOfClass(
                JScrollPane.class, scene.getView());
        assert pane != null : "Scene view component not in a JScrollPane?!?";
        if (pane == null) {
            return;
        }
        JViewport viewport = pane.getViewport();
        Rectangle visRect = viewport.getViewRect();
        Point center = new Point(visRect.x + visRect.width / 2, visRect.y + visRect.height / 2);
        setZoom(percent, center);
    }

    
/**
     * Set the zoom factor for the Scene mananged by this ZoomManager
     * instance. The value represents a percentage (e.g. 100%) and
     * must be a positive number. Any value outside of the defined
     * range (<tt>MIN_ZOOM_PERCENT</tt> and <tt>MAX_ZOOM_PERCENT</tt>)
     * will be forced into that range.
     *
     * @param  percent  the percent value (e.g. 50 for half-size,
     *                  200 for double-size).
     * @param  center   the point at which to zoom in and keep centered.
     */
    public void setZoom(int percent, Point center) {
        if (percent < MIN_ZOOM_PERCENT) {
            percent = MIN_ZOOM_PERCENT;
        } else {
            if (percent > MAX_ZOOM_PERCENT) {
                percent = MAX_ZOOM_PERCENT;
            }
        }

        // Find the current center point prior to zooming.
        Point sceneCenter = scene.convertViewToScene(center);
        zoomPercentage = percent;
        // Convert the percent value to the zoom factor Scene is expecting
        // (a double that acts as the multiplier to the component sizes and
        // locations, such that 0.5 is 50%, 1.0 is 100%, and 2.0 is 200%.
        double factor = ((double) percent) / 100.0d;
        scene.setZoomFactor(factor);
        if (scene instanceof DesignerScene) {
            DesignerScene ds = (DesignerScene) scene;
            if (ds.getTopComponent() instanceof SQDDiagramTopComponent) {
                SQDDiagramTopComponent tc = (SQDDiagramTopComponent) ds.getTopComponent();
                tc.getTrackBar().onPostScrollZoom();
            }
        }
        // Setting the zoom factor alone is not enough, must force
        // validation and repainting of the scene for it to work.
        scene.validate();
        scene.repaint();

        // Find the new center point and scroll the view after zooming.
        Point newViewCenter = scene.convertSceneToView(sceneCenter);
        JComponent view = scene.getView();
        Rectangle visRect = view.getVisibleRect();
        visRect.x = newViewCenter.x - (center.x - visRect.x);
        visRect.y = newViewCenter.y - (center.y - visRect.y);
        Dimension viewSize = view.getSize();
        if (visRect.x + visRect.width > viewSize.width) {
            visRect.x = viewSize.width - visRect.width;
        }
        if (visRect.y + visRect.height > viewSize.height) {
            visRect.y = viewSize.height - visRect.height;
        }
        if (visRect.x < 0) {
            visRect.x = 0;
        }
        if (visRect.y < 0) {
            visRect.y = 0;
        }
        view.scrollRectToVisible(visRect);
        view.revalidate();
        view.repaint();

        // Notify registered listeners so they may update their state.
        fireZoomEvent(percent);
    }

    public void zoomToFit() {
        JScrollPane pane = (JScrollPane) SwingUtilities.getAncestorOfClass(
                JScrollPane.class, scene.getView());
        if (pane == null) {
            // Unlikely, but we cannot assume it exists.
            return;
        }

        JViewport viewport = pane.getViewport();
        Rectangle visRect = viewport.getViewRect();
        if (pane.getVerticalScrollBar() != null && !pane.getVerticalScrollBar().isVisible())//if scroll isn't visible add some space because it may appear after zoom
        {
            visRect.width -= 20;
        }
        if (pane.getHorizontalScrollBar() != null && !pane.getHorizontalScrollBar().isVisible()) {
            visRect.height -= 20;
        }
        Rectangle compRect = null;
        Rectangle clientArea = getSceneContentRect();
        if (clientArea != null) {
            compRect = clientArea;
        } else {
            compRect = new Rectangle();
        }

        if ((compRect.width > 0) && (compRect.height > 0)) {
            int zoomX = visRect.width * 100 / compRect.width;
            int zoomY = visRect.height * 100 / compRect.height;
            int zoom = Math.min(zoomX, zoomY);
            setZoom(zoom);
            //
            scene.getView().scrollRectToVisible(scene.convertSceneToView(compRect));
        }
    }

    private Rectangle getSceneContentRect() {
        Insets insets = scene.getBorder().getInsets();
        Rectangle clientArea = null;//calculate real bounds of scene content (withou 0-0 point)
        for (Widget child0 : scene.getChildren()) {
            if (!child0.isVisible()) {
                continue;
            }
            for (Widget child : child0.getChildren())//first layer is layers, also may count 0-0 point
            {
                Point location = child.getLocation();
                Rectangle bounds = child.getBounds();
                bounds.translate(location.x, location.y);
                if (clientArea == null) {
                    clientArea = new Rectangle(bounds);
                } else {
                    clientArea.add(bounds);
                }
            }
        }
        if (clientArea == null) {
            clientArea = new Rectangle();
        }
        if (insets != null)//shouldn't be null but somehow may be null if border isn't initialized correctly
        {
            clientArea.x -= insets.left;
            clientArea.y -= insets.top;
            clientArea.width += insets.left + insets.right;
            clientArea.height += insets.top + insets.bottom;
        }
        return clientArea;
    }

    
/**
     * Manages the combobox for setting the zoom level.
     */
    private static class ZoomComboBox extends JComboBox {

        /** The associated zoom manager. */
        private ZoomManager manager;

        
/**
         * Creates a new instance of ZoomComboBox.
         *
         * @param  manager  the zoom manager.
         */
        public ZoomComboBox(ZoomManager manager) {
            super(new Model());
            this.manager = manager;
            // The combo will expand to fill all available space, so
            // instead, give it a prototype value and then ask for the
            // preferred size, making that the maximum size
            // (make it wide enough to accomodate the '%').
            setPrototypeDisplayValue(new Integer(100000));
            setMaximumSize(getPreferredSize());
            setEditable(true);
            Listener l = new Listener(manager);
            // We can't listen to ourselves, so use a delegate.
            addActionListener(l);
            manager.addZoomListener(l);
        }

        
/**
         * Combobox model, provides default zoom values.
         */
        private static class Model extends DefaultComboBoxModel {

            
/**
             * Creates a new instance of Model.
             */
            public Model() {
                addElement(new Value(10));
                addElement(new Value(25));
                addElement(new Value(50));
                addElement(new Value(75));
                Value def = new Value(DEFAULT_ZOOM_PERCENT);
                addElement(def);
                addElement(new Value(150));
                addElement(new Value(200));
                addElement(new Value(400));
                addElement(new Value(MAX_ZOOM_PERCENT));
                setSelectedItem(def);
            }
        }

        
/**
         * Class Value represents a combobox element.
         */
        private static class Value {

            /** The value of the combobox element. */
            private int value;
            /** The String to represent this value. */
            private String str;

            
/**
             * Creates a new instance of Value.
             *
             * @param  value  the zoom value (e.g. 75, 100, 150).
             */
            public Value(int value) {
                this.value = value;
                str = value + "%";
            }

            @Override
            public boolean equals(Object o) {
                if (o instanceof Value) {
                    return value == ((Value) o).getValue();
                }
                return false;
            }

            @Override
            public int hashCode() {
                return value;
            }

            
/**
             * Returns the integer value of this instance.
             *
             * @return  integer value.
             */
            public int getValue() {
                return value;
            }

            @Override
            public String toString() {
                return str;
            }
        }

        
/**
         * Listener to the combobox and zoom manager.
         */
        private class Listener implements ActionListener, ZoomListener {

            /** The associated zoom manager. */
            private ZoomManager manager;

            
/**
             * Creates a new instance of Listener.
             *
             * @param  manager  the zoom manager.
             */
            public Listener(ZoomManager manager) {
                this.manager = manager;
            }

            public void actionPerformed(ActionEvent event) {
                Object src = event.getSource();
                String cmd = event.getActionCommand();
                if (src == ZoomComboBox.this && cmd.equals(ZoomComboBox.this.getActionCommand())) {
                    // Ignore the "edited" action, since the "changed" action
                    // is sent on both accounts (selection or edit).
                    Object item = ZoomComboBox.this.getSelectedItem();
                    Value value = null;
                    if (item instanceof String) {
                        String str = (String) item;
                        if (str.endsWith("%")) {
                            str = str.substring(0, str.length() - 1);
                        }
                        try {
                            int i = Integer.parseInt(str);
                            value = new Value(i);
                        } catch (NumberFormatException nfe) {
                            // ignore and fall through
                        }
                    } else {
                        if (item instanceof Value) {
                            value = (Value) item;
                        }
                    }
                    if (value == null) {
                        value = new Value(ZoomComboBox.this.manager.getZoom());
                    }
                    manager.setZoom(value.getValue());
                }
            }

            public void zoomChanged(ZoomEvent event) {
                // Set the selected combobox value.
                ZoomComboBox.this.removeActionListener(this);
                ZoomComboBox.this.setSelectedItem(new Value(event.getPercent()));
                ZoomComboBox.this.addActionListener(this);
            }
        }
    }

    
/**
     * Event object representing a change in the zoom level of a ZoomManager.
     */
    public static class ZoomEvent extends EventObject {

        /** Percent value of the zoom manager at the time of the event. */
        private int percent;

        
/**
         * Creates a new instance of ZoomEvent.
         *
         * @param  src      the source of the event.
         * @param  percent  the new zoom percent value.
         */
        public ZoomEvent(Object src, int percent) {
            super(src);
            this.percent = percent;
        }

        
/**
         * Returns the percent value of the zoom manager at the time of
         * the event.
         *
         * @return  percent value.
         */
        public int getPercent() {
            return percent;
        }
    }

    
/**
     * The listener interface for receiving zoom events.
     */
    public static interface ZoomListener extends EventListener {

        
/**
         * The zoom level of the ZoomManager has changed.
         *
         * @param  event  the zoom event.
         */
        void zoomChanged(ZoomEvent event);
    }

    
/**
     * Implements the fit-diagram feature, such that it sets the zoom to
     * show the Scene contents at the largest percentage while still
     * fitting within the available scroll area.
     */
    private static class FitDiagramAction extends AbstractAction {

        /** The associated ZoomManager. */
        private ZoomManager manager;

        
/**
         * Creates a new instance of FitDiagramAction.
         *
         * @param  manager  the zoom manager.
         */
        public FitDiagramAction(ZoomManager manager) {
            this.manager = manager;

            ImageUtil util = ImageUtil.instance();
            Icon img = util.getIcon("fit-to-window.png");
            if (img != null) {
                putValue(Action.SMALL_ICON, img);
            }
            String desc = NbBundle.getMessage(FitDiagramAction.class, "LBL_FitDiagramAction");
            putValue(Action.NAME, desc); // for accessibility
            putValue(Action.SHORT_DESCRIPTION, desc);

            putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl shift F"));
        }

        public void actionPerformed(ActionEvent e) {
            manager.zoomToFit();
        }
    }

    
/**
     * Implements the fit-width feature, such that it sets the zoom to
     * show the Scene contents at the largest percentage while still
     * fitting within the width of the available scroll area.
     */
    private class FitWidthAction extends AbstractAction {

        /** The associated ZoomManager. */
        private ZoomManager manager;

        
/**
         * Creates a new instance of FitWidthAction.
         *
         * @param  manager  the zoom manager.
         */
        public FitWidthAction(ZoomManager manager) {
            this.manager = manager;
            ImageUtil util = ImageUtil.instance();
            Icon img = util.getIcon("fit-width.png");
            if (img != null) {
                putValue(Action.SMALL_ICON, img);
            }
            String desc = NbBundle.getMessage(FitWidthAction.class, "LBL_FitWidthAction");
            putValue(Action.NAME, desc); // for accessibility
            putValue(Action.SHORT_DESCRIPTION, desc);
            putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl shift L"));
        }

        public void actionPerformed(ActionEvent e) {
            Scene scene = manager.getScene();
            JScrollPane pane = (JScrollPane) SwingUtilities.getAncestorOfClass(
                    JScrollPane.class, scene.getView());
            if (pane == null) {
                // Unlikely, but we cannot assume it exists.
                return;
            }
            JViewport viewport = pane.getViewport();
            Rectangle visRect = viewport.getViewRect();
            if (pane.getVerticalScrollBar() != null && !pane.getVerticalScrollBar().isVisible())//if scroll isn't visible add some space because it may appear after zoom
            {
                visRect.width -= 20;
            }
            if (pane.getHorizontalScrollBar() != null && !pane.getHorizontalScrollBar().isVisible()) {
                visRect.height -= 20;
            }
            Rectangle compRect = null;
            Rectangle clientArea = getSceneContentRect();
            if (clientArea != null) {
                compRect = clientArea;
            } else {
                compRect = new Rectangle();
            }
            if (compRect.width > 0) {
                int zoom = visRect.width * 100 / compRect.width;
                manager.setZoom(zoom);
                //
                scene.getView().scrollRectToVisible(scene.convertSceneToView(compRect));
            }
        }
    }

    
/**
     * Implements the 100% zoom feature, such that it sets the zoom percent
     * to the fixed value of 100 (the default zoom level).
     */
    private static class ZoomDefaultAction extends AbstractAction {

        /** The associated ZoomManager. */
        private ZoomManager manager;

        
/**
         * Creates a new instance of ZoomDefaultAction.
         *
         * @param  manager  the zoom manager.
         */
        public ZoomDefaultAction(ZoomManager manager) {
            this.manager = manager;
            ImageUtil util = ImageUtil.instance();
            Icon img = util.getIcon("normal-size.png");
            if (img != null) {
                putValue(Action.SMALL_ICON, img);
            }
            String desc = NbBundle.getMessage(ZoomDefaultAction.class, "LBL_ZoomDefaultAction");
            putValue(Action.NAME, desc); // for accessibility
            putValue(Action.SHORT_DESCRIPTION, desc);
            putValue(Action.ACCELERATOR_KEY, KeyStroke.getKeyStroke("ctrl shift D"));
        }

        public void actionPerformed(ActionEvent e) {
            manager.setZoom(ZoomManager.DEFAULT_ZOOM_PERCENT);
        }
    }

    
/**
     * Implements the zoom-in feature, such that it sets the zoom percent
     * to a decreased amount for the scene.
     */
    private static class ZoomInAction extends AbstractAction implements ZoomListener {

        /** The associated ZoomManager. */
        private ZoomManager manager;

        
/**
         * Creates a new instance of ZoomInAction.
         *
         * @param  manager  the zoom manager.
         */
        public ZoomInAction(ZoomManager manager) {
            this.manager = manager;
            ImageUtil util = ImageUtil.instance();
            Icon img = util.getIcon("zoom-in.png");
            if (img != null) {
                putValue(Action.SMALL_ICON, img);
            }
            String desc = NbBundle.getMessage(ZoomInAction.class, "LBL_ZoomInAction");
            putValue(Action.NAME, desc); // for accessibility
            putValue(Action.SHORT_DESCRIPTION, desc);

            KeyStroke keystroke = KeyStroke.getKeyStroke(KeyEvent.VK_PLUS,
                    KeyEvent.CTRL_MASK);
            KeyStroke macStroke = KeyStroke.getKeyStroke(KeyEvent.VK_PLUS,
                    KeyEvent.META_MASK);

            KeyStroke[] additionalKeystrokes = {
                //KeyStroke.getKeyStroke(KeyEvent.VK_EQUALS, KeyEvent.CTRL_MASK|KeyEvent.SHIFT_MASK),
                KeyStroke.getKeyStroke(KeyEvent.VK_EQUALS, KeyEvent.CTRL_MASK),
                KeyStroke.getKeyStroke(KeyEvent.VK_ADD, KeyEvent.CTRL_MASK)
            };

            KeyStroke[] additionalMacKeystrokes = {
                //KeyStroke.getKeyStroke(KeyEvent.VK_EQUALS, KeyEvent.META_MASK|KeyEvent.SHIFT_MASK),
                KeyStroke.getKeyStroke(KeyEvent.VK_EQUALS, KeyEvent.META_MASK),
                KeyStroke.getKeyStroke(KeyEvent.VK_ADD, KeyEvent.CTRL_MASK)
            };

            putValue(Action.ACCELERATOR_KEY, keystroke);
            putValue(DiagramInputkeyMapper.MAC_ACCELERATOR, macStroke);
            putValue(DiagramInputkeyMapper.ADDITIONAL_ACCELERATORS, additionalKeystrokes);
            putValue(DiagramInputkeyMapper.ADDITIONAL_MAC_ACCELERATORS, additionalMacKeystrokes);
        }

        public void actionPerformed(ActionEvent e) {
            int percent = manager.getZoom();
            percent = ZoomManager.calculateZoomInValue(percent);
            manager.setZoom(percent);
        }

        public void zoomChanged(ZoomEvent event) {
            boolean enable = event.getPercent() < MAX_ZOOM_PERCENT;
            setEnabled(enable);
        }
    }

    
/**
     * Implements the zoom-out feature, such that it sets the zoom percent
     * to an increased amount for the scene.
     */
    private static class ZoomOutAction extends AbstractAction implements ZoomListener {

        /** The associated ZoomManager. */
        private ZoomManager manager;

        
/**
         * Creates a new instance of ZoomOutAction.
         *
         * @param  manager  the zoom manager.
         */
        public ZoomOutAction(ZoomManager manager) {
            this.manager = manager;
            ImageUtil util = ImageUtil.instance();
            Icon img = util.getIcon("zoom-out.png");
            if (img != null) {
                putValue(Action.SMALL_ICON, img);
            }
            String desc = NbBundle.getMessage(ZoomOutAction.class, "LBL_ZoomOutAction");
            putValue(Action.NAME, desc); // for accessibility
            putValue(Action.SHORT_DESCRIPTION, desc);

            KeyStroke keystroke = KeyStroke.getKeyStroke(KeyEvent.VK_MINUS,
                    KeyEvent.CTRL_MASK);
            KeyStroke macStroke = KeyStroke.getKeyStroke(KeyEvent.VK_MINUS,
                    KeyEvent.META_MASK);

            KeyStroke[] additionalKeystrokes = {
                //KeyStroke.getKeyStroke(KeyEvent.VK_MINUS, KeyEvent.CTRL_MASK|KeyEvent.SHIFT_MASK),
                KeyStroke.getKeyStroke(KeyEvent.VK_SUBTRACT, KeyEvent.CTRL_MASK)
            };

            KeyStroke[] additionalMacKeystrokes = {
                //KeyStroke.getKeyStroke(KeyEvent.VK_MINUS, KeyEvent.META_MASK|KeyEvent.SHIFT_MASK),
                KeyStroke.getKeyStroke(KeyEvent.VK_SUBTRACT, KeyEvent.META_MASK)
            };

            putValue(Action.ACCELERATOR_KEY, keystroke);
            putValue(DiagramInputkeyMapper.MAC_ACCELERATOR, macStroke);
            putValue(DiagramInputkeyMapper.ADDITIONAL_ACCELERATORS, additionalKeystrokes);
            putValue(DiagramInputkeyMapper.ADDITIONAL_MAC_ACCELERATORS, additionalMacKeystrokes);
        }

        public void actionPerformed(ActionEvent e) {
            int percent = manager.getZoom();
            percent = ZoomManager.calculateZoomOutValue(percent);
            manager.setZoom(percent);
        }

        public void zoomChanged(ZoomEvent event) {
            boolean enable = event.getPercent() > MIN_ZOOM_PERCENT;
            setEnabled(enable);
        }
    }

    public void sceneRepaint() {
    }

    public void sceneValidating() {
    }

    public void sceneValidated() {
        fireZoomEvent((int) (scene.getZoomFactor() * 100));
        if (scene.getZoomFactor() * 100 >= MAX_ZOOM_PERCENT
                || scene.getZoomFactor() * 100 <= MIN_ZOOM_PERCENT) {
            // disable marquee zoom 
            if (scene.getActiveTool().equals(DesignerTools.MARQUEE_ZOOM)) {
                scene.setCursor(getMarqueeZoomStopCursor());
            }
        } else {
            // reset marquee zoom cursor
            if (scene.getActiveTool().equals(DesignerTools.MARQUEE_ZOOM)) {
                scene.setCursor(getMarqueeZoomCursor());
            }
        }

    }

    private Cursor getMarqueeZoomCursor() {
        if (zoomCursor == null) {
            zoomCursor = Utilities.createCustomCursor(scene.getView(),
                    ImageUtilities.icon2Image(ImageUtil.instance().getIcon("marquee-zoom.gif")), "MarqueeZoom");
        }
        return zoomCursor;
    }

    private Cursor getMarqueeZoomStopCursor() {
        if (zoomStopCursor == null) {
            zoomStopCursor = Utilities.createCustomCursor(scene.getView(),
                    ImageUtilities.icon2Image(ImageUtil.instance().getIcon("marquee-zoom-stop.gif")), "MarqueeZoomStop");
        }
        return zoomStopCursor;
    }
}
