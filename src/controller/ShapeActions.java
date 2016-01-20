/**
 * 
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import view.ArtPanel;

/**
 * Project 2.
 * TCSS 305
 * @author Athena Castillo
 * @version 6/11/15
 */
public class ShapeActions extends AbstractAction {

    /**
     * serial for check styles.
     */
    private static final long serialVersionUID = 1L;

    /**
     * constructor.
     * @param thePanel panel being used.
     * @param theIcon icon being used.
     * @param theM mouseadapter being used.
     */
    public ShapeActions(final JPanel thePanel, final ImageIcon theIcon, 
                        final MouseAdapter theM) {
        putValue("panel", thePanel);
        putValue(Action.SMALL_ICON, theIcon);
        putValue("MouseAdapter", theM);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void actionPerformed(final ActionEvent theE) {
        // TODO Auto-generated method stub
        putValue(Action.SELECTED_KEY, true);
        final ArtPanel panel = (ArtPanel) getValue("panel");
        final MouseAdapter m = (MouseAdapter) getValue("MouseAdapter");
        panel.resetMouseListener(m);
                        
    }

}
