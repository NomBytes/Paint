/**
 * 
 */
package controller;

import java.awt.Color;
import java.awt.Point;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import model.ArtModel;
import model.ShapeProperties;

/**
 * Project 2.
 * TCSS 305
 * @author Athena Castillo
 * @version 6/11/15
 */
public class RectangleMouser extends MouseAdapter {
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
    private ShapeProperties myShapeProp;
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
     * @param theC color
     * @param theShapes list of shape props.
     * @param theFlag fill.
     */
    public RectangleMouser(final JPanel thePanel, final ArtModel theArtMod, 
                           final Color theC, final boolean theFlag, 
                           final List<ShapeProperties> theShapes) {

        myP1 = new Point();
        myP2 = new Point();

        //myStroke = new BasicStroke(stroke);
        this.myStroke = 0;
        //myShape = theShape;
        //myList = shapes;
        myList = theShapes;
        myFlag = theFlag;
        myColor = theC;
        myArt = thePanel;
        myArtMod = theArtMod;

    }
    /**
     * sets the color.
     * @param theC color
     */
    public void setColor(final Color theC) {
        myColor = theC;
    }
    /**
     * sets the fill.
     * @param theFlag for fill.
     */
    public void setFlag(final Boolean theFlag) {
        myFlag = theFlag;
    }
    /**
     * sets the stroke.
     * @param theS the stroke.
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
            myShape = new Rectangle2D.Double(myP1.getX(), myP1.getY(), 0, 0);
        } else {
            myShape = null;
        }

    }

    @Override
    public void mouseReleased(final MouseEvent theEvent) {
        if (myShape != null) {
            
            myArtMod.add(myShapeProp);
        }

    }

    @Override
    public void mouseDragged(final MouseEvent theEvent) {
        myP2.setLocation(theEvent.getX(), theEvent.getY());
        if (myShape != null) {
            
            final Rectangle2D.Double rect = (Rectangle2D.Double) myShape;
            
            rect.setRect(myP1.getX(), myP1.getY(), Math.abs(myP1.getX()-myP2.getX()),
                         Math.abs(myP1.getY() - theEvent.getY()));
            

            myShapeProp = new ShapeProperties(myShape, myColor);
            myShapeProp.setFlag(myFlag);
            myShapeProp.setStroke(myStroke);
            myList.add(myShapeProp);
            
        }
        myArt.repaint();
    }

}
