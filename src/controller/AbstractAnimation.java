/**
 * 
 */
package controller;

import java.awt.event.ActionListener;
import java.awt.geom.GeneralPath;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.awt.geom.RectangularShape;
import java.util.List;

import javax.swing.JPanel;

import model.ArtModel;
import model.ShapeProperties;

/**
 * Project 2
 * TCSS 305
 * @author Athena Castillo
 * @version 6/11/15
 */
public abstract class AbstractAnimation implements ActionListener{

    /** 
     * artmodel.
     */
    protected ArtModel myArtMod;
    /**
     * the pane.
     */
    protected JPanel myPanel;
    /**
     * horizontal movement.
     */
    protected int myHorizontalMove;
    /**
     * vertical movement.
     */
    protected int myVerticalMove;
    /**
     * my speed.
     */
    protected int mySpeed;
    /**
     * list of shape props.
     */
    protected List<ShapeProperties> myShapePropList;
    /**
     * 
     * @param thePanel panel being animated on.
     * @param theArtMod model being used.
     */
    public AbstractAnimation(final JPanel thePanel, final ArtModel theArtMod) {
        myPanel = thePanel;
        myArtMod = theArtMod;
  
        myShapePropList = myArtMod.getList();
        mySpeed = 1;
        myHorizontalMove = mySpeed;
        myVerticalMove = mySpeed;

    }
    /**
     * steps foward the animation.
     */
    public abstract void fastForward();
    /**
     * updates horizontal movement.
     */
    public void updateHorizontalMove() {
        for (ShapeProperties i : myShapePropList) {
            if (i.getShape() instanceof RectangularShape) {
                if (((RectangularShape) i.getShape()).getMaxX() > myPanel.getWidth()) {
                    myHorizontalMove = -mySpeed;
                
                }else if(i.getShape() instanceof Path2D){
                    Point2D point = ((GeneralPath) i.getShape()).getCurrentPoint();
                    if(point.getX() > myPanel.getWidth()){
                        myVerticalMove = -mySpeed;
                    }else if(point.getX() <= 0){
                        myVerticalMove = mySpeed;
                    }
                }
            }
        }
    }
    /**
     * updates vertical movement.
     */
    public void updateVerticalMove() {
        for (ShapeProperties i : myShapePropList) {
            if (i.getShape() instanceof RectangularShape) {
                if (((RectangularShape) i.getShape()).getMaxY() > myPanel.getHeight()) {
                    myVerticalMove = -mySpeed;
                
                } else if (((RectangularShape) i.getShape()).getMinY() <= 0) {
                    myVerticalMove = mySpeed;
                    //System.out.println("updateHorizontalMove() in animation 1");
                    //System.out.println(horizontalMove);
                }
            }else if(i.getShape() instanceof Path2D){
                Point2D point = ((GeneralPath) i.getShape()).getCurrentPoint();
                if(point.getY() > myPanel.getHeight()){
                    myVerticalMove = -mySpeed;
                }else if(point.getY() <= 0){
                    myVerticalMove = mySpeed;
                }
            }
        }
    }

}
