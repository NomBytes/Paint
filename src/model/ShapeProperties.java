/**
 * 
 */
package model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.geom.RectangularShape;

/**
 * Project 2.
 * TCSS 305
 * @author Athena Castillo
 * @version 6/11/15
 */
public class ShapeProperties {
    /**
     * shape.
     */
    private Shape myShape;
    /**
     * flag for fill.
     */
    private boolean myFlag;
    /**
     * color of shape.
     */
    private Color myColor;
    /**
     * stroke for shape.
     */
    private BasicStroke myStroke;
    /**
     * original x coordinate.
     */
    private double myOriginalX;
    /**
     * original y corrdinate.
     */
    private double myOriginalY;
    /**
     * for moving general paths.
     */
    private AffineTransform myTrans;
    /**
     * constructor.
     * @param theShape shape
     * @param theC color
     */
    public ShapeProperties(final Shape theShape, final Color theC) {
        myShape = theShape;
        myFlag = false;
        myColor = theC;
        myStroke = new BasicStroke();
        myTrans = new AffineTransform();
        if (myShape instanceof RectangularShape) {
            myOriginalX = ((RectangularShape) myShape).getX();
            myOriginalY = ((RectangularShape) myShape).getY();
            
        } else if (myShape instanceof GeneralPath) {
            myOriginalX = ((GeneralPath) theShape).getCurrentPoint().getX();
            myOriginalY = ((GeneralPath) theShape).getCurrentPoint().getY();
        }
        
    }
    /**
     * copy constructor.
     * @param theShape being copied.
     */
    public ShapeProperties(final ShapeProperties theShape) {
        this(theShape.getShape(), theShape.getColor());
    }

    /**
     * gives flag for fill.
     * @return gives flag.
     */
    public boolean getFlag() {
        return myFlag;

    }

    /**
     * changes the flag.
     * @param theFlag flag being set.
     */
    public void setFlag(final boolean theFlag) {

        myFlag = theFlag;
    }

    /**
     * gives shape.
     * @return gives shape.
     */
    public Shape getShape() {
        if (myShape instanceof RectangularShape) {
            return (RectangularShape) myShape;
        }
        return myShape;
    }

    /**
     * gives color.
     * @return gives color.
     */
    public Color getColor() {
        return myColor;
    }

    /**
     * gives stroke.
     * @return gives stroke.
     */
    public BasicStroke getStroke() {
        // System.out.println("getStroke");
        return myStroke;
    }
    /**
     * gives OriginalLocation.
     * @return orgina x.
     */
    public double getOriginalX() {

        return myOriginalX;
    }

    /**
     * gives y.
     * @return original y
     */
    public double getOriginalY() {
        return myOriginalY;
    }

    /**
     * setting transform.
     * 
     * @param theT changes transform.
     * @custom.post myTrans = theT.
     */
    public void setTransform(final AffineTransform theT) {
        this.myTrans = theT;
    }

    /**
     * for moving general paths.
     * 
     * @return the transform for this shape.
     */
    public AffineTransform getTrans() {
        return myTrans;
    }

    /**
     * sets the stroke.
     * 
     * @param theN new stroke
     * @custom.post myStroke = theN
     */
    public void setStroke(final int theN) {
        // System.out.println("setStroke in ShapeProperties" + n);
        myStroke = new BasicStroke(theN);
    }

}
