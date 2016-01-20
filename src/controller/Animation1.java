/**
 * 
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.geom.Path2D;
import java.awt.geom.Path2D.Float;
import java.awt.geom.Point2D;
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
public class Animation1 extends AbstractAnimation {
    /**
     * constructor for animation1.
     * @param thePanel panel being animated
     * @param theArtMod model being used.
     */
    public Animation1(final JPanel thePanel, final ArtModel theArtMod) {
        super(thePanel, theArtMod);
 
    }
 
    @Override
    public void actionPerformed(final ActionEvent theEvent) { 


        //updateVerticalMove();
        updateHorizontalMove();
        for (ShapeProperties i : myShapePropList) {
            if (i.getShape() instanceof RectangularShape) {
                ((RectangularShape) i.getShape()).setFrame(((RectangularShape) i.getShape()).
                                                           getX()
                                                           + myHorizontalMove,
                                                           ((RectangularShape) i.getShape()).
                                                           getY()
                                                           ,
                                                           ((RectangularShape) i.getShape()).
                                                           getWidth()
                                                           ,
                                                           ((RectangularShape) i.getShape()).
                                                           getHeight()
                );
            }else if(i.getShape() instanceof Path2D){
                System.out.print("hi");
               Point2D point = ((GeneralPath) i.getShape()).getCurrentPoint();
               ((Path2D) i.getShape()).moveTo(point.getX() + myHorizontalMove, point.getY());
               ((Path2D) i.getShape()).quadTo(point.getX(), point.getY(), point.getX() + myHorizontalMove, point.getY());
              AffineTransform myTransForm = AffineTransform.getTranslateInstance(point.getX() + myHorizontalMove, 
                                                                  point.getY());
                //i.setTransform(myTransForm);
                //((GeneralPath) i.getShape()).closePath();
                                                    
            }
        }
        myPanel.repaint();
    }
    @Override
    public void fastForward() {
        updateHorizontalMove();
        for (ShapeProperties i : myShapePropList) {
            if (i.getShape() instanceof RectangularShape) {
                System.out.print("blag");
                ((RectangularShape) i.getShape()).setFrame(((RectangularShape) i.getShape()).
                                                           getX() + myHorizontalMove,
                                                           ((RectangularShape) i.getShape()).
                                                           getY(),
                                                           ((RectangularShape) i.getShape()).
                                                           getWidth()
                                                           ,
                                                           ((RectangularShape) i.getShape()).
                                                           getHeight());
                
            }else if(i.getShape() instanceof Path2D){
                //System.out.print("hi");
               Point2D point = ((GeneralPath) i.getShape()).getCurrentPoint();
                   AffineTransform myTransForm = new AffineTransform();
               ((Path2D) i.getShape()).createTransformedShape(myTransForm);
                //((GeneralPath) i.getShape()).closePath();
                                                    
            }
        }
        myPanel.repaint();
        // TODO Auto-generated method stub
        
    }

}
