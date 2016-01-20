/**
 * 
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.geom.RectangularShape;

import javax.swing.JPanel;

import model.ArtModel;
import model.ShapeProperties;

/**
 * Project 2.
 * TCSS 305.
 * @author Athena Castillo
 * @version 6/11/15
 */
public class Animation2 extends AbstractAnimation {
  

    /**
     * constructor for animation2.
     * @param thePanel panel being animated
     * @param theArtMod model being used.
     */
    public Animation2(final JPanel thePanel, final ArtModel theArtMod) {
        super(thePanel, theArtMod);
        
        // TODO Auto-generated constructor stub

    }
    @Override
    public void fastForward() {
        updateVerticalMove();
        for (ShapeProperties i : myShapePropList) {
            if (i.getShape() instanceof RectangularShape) {
                ((RectangularShape) i.getShape()).setFrame(((RectangularShape) i.getShape()).
                                                           getX(),
                                                           ((RectangularShape) i.getShape()).
                                                           getY() + myVerticalMove
                                                           ,
                                                           ((RectangularShape) i.getShape()).
                                                           getWidth()
                                                           ,
                                                           ((RectangularShape) i.getShape()).
                                                           getHeight());

            }
        }
        myPanel.repaint();
    }
 
    @Override
    public void actionPerformed(final ActionEvent theEvent) {

        // updateVerticalMove();
        updateVerticalMove();
        for (ShapeProperties i : myShapePropList) {
            if (i.getShape() instanceof RectangularShape) {
                ((RectangularShape) i.getShape()).setFrame(((RectangularShape) i.getShape()).
                                                           getX()
                                                           , 
                                                           ((RectangularShape) i.getShape()).
                                                           getY()
                                                           + myVerticalMove
                                                           , 
                                                           ((RectangularShape) i.getShape()).
                                                           getWidth()
                                                           , 
                                                           ((RectangularShape) i.getShape()).
                                                           getHeight());
            }
        }
        myPanel.repaint();
    }

}
