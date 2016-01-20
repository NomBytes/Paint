/**
 * 
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;

import view.ArtPanel;

/**
 * Project 2.
 * TCSS 305
 * @author Athena Castillo
 * @version 6/11/15
 */
public class AnimationActions extends AbstractAction {

    /**
     * for check style.
     */
    private static final long serialVersionUID = 1L;

    /**
     * constructor.
     * @param thePanel panel being used.
     * @param theIcon icon being used.
     * @param theM actionlistener being used.
     */
    public AnimationActions(final ArtPanel thePanel, final ImageIcon theIcon, 
                            final ActionListener theM) {
        putValue("panel", thePanel);
        putValue(Action.SMALL_ICON, theIcon);
        putValue("Action", theM);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void actionPerformed(final ActionEvent theE) {
        // TODO Auto-generated method stub
        putValue(Action.SELECTED_KEY, true);
        final ArtPanel panel = (ArtPanel) getValue("panel");
        final ActionListener m = (ActionListener) getValue("Action");
        panel.setTimer(m);
                        
    }

}
