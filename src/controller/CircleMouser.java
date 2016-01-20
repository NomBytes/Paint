/**
 * 
 */
package controller;

import java.awt.Color;
import java.awt.Point;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import model.ArtModel;
import model.ShapeProperties;

/**
 * Project 2.
 * TCSS 305.
 * @author Athena Castillo
 * @version 6/11/15
 */
public class CircleMouser extends MouseAdapter {
    /**
     * the first point.
     */
    private Point myP1;
    /**
     * The second point.
     */
    private Point myP2;
    /**
     * Path where the line is being drawn.
     */
    private Shape myShape;
    /**
     * colrs.
     */
    private Color myColor;
    /** 
     * art model.
     */
    private ArtModel myArtMod;
    /**
     * the panel.
     */
    private JPanel myArt;
    /**
     * flag for fill.
     */
    private boolean myFlag;
    /**
     * the shapes propertes.
     */
    private ShapeProperties myShapes;
    /**
     * the stroke.
     */
    private int myStroke;
    /**
     * List for keeping track of shapes.
     */
    private List<ShapeProperties> myList;
    /**
     *  constructor.
     * @param thePanel panel
     * @param theArtMod modle
     * @param theColor color
     * @param theShape list of shape props.
     * @param theFlag fill.
     */
    public CircleMouser(final JPanel thePanel, final ArtModel theArtMod, final Color theColor,
                        final boolean theFlag, final List<ShapeProperties> theShape) {

        myP1 = new Point();
        myP2 = new Point();
        this.myStroke = 0;
        //myShape = theShape;
        myList = theShape;
        myFlag = theFlag;
        myColor = theColor;
        myArt = thePanel;
        myArtMod = theArtMod;

    }
    
    /**
     * sets the color.
     * @param theC color
     * @custom.post color is now theC.
     */
    public void setColor(final Color theC) {
        myColor = theC;
    }
    /**
     * sets the fill.
     * @param theFlag for fill.
     * @custom.post myFlag = theFlag.
     */
    public void setFlag(final Boolean theFlag) {
        myFlag = theFlag;
    }
    /**
     * sets the stroke.
     * @param theS the stroke.
     * @custom.post myStroke = theS.
     */
    public void setStroke(final int theS) {
        myStroke = theS;
    }
    /**
     * Where the doodle starts.
     * 
     * @param theEvent where the mouse is pressed.
     */
    @Override
    public void mousePressed(final MouseEvent theEvent) {
        myP1.setLocation(theEvent.getX(), theEvent.getY());
        //myP2.setLocation(theEvent.getX(), theEvent.getY());
        if (SwingUtilities.isLeftMouseButton(theEvent)) {
            myShape = new Ellipse2D.Double(myP1.getX(), myP1.getY(), 0, 0);
        } else {
            myShape = null;
        }

    }

    @Override
    public void mouseReleased(final MouseEvent theEvent) {
        if (myShape != null) {
            
            myArtMod.add(myShapes);
        }

    }

    @Override
    public void mouseDragged(final MouseEvent theEvent) {
        myP2.setLocation(theEvent.getX(), theEvent.getY());
        if (myShape != null) {
            
            final Ellipse2D.Double ell = (Ellipse2D.Double) myShape;
            ell.setFrame(myP1.getX(), myP1.getY(), Math.abs(myP1.getX() - myP2.getX()),
                         Math.abs(myP1.getY() - myP2.getY()));
            
            myShapes = new ShapeProperties(myShape, myColor);
            myShapes.setFlag(myFlag);
            myShapes.setStroke(myStroke);
            myList.add(myShapes);
            
        }
        myArt.repaint();
    }

}
