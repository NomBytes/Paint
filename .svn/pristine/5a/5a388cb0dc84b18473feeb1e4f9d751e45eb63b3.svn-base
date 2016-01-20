/**
 * 
 */
package model;

import java.awt.Shape;
import java.util.ArrayList;
import java.util.List;

/**
 * Project 2.
 * TCSS 305
 * @author Athena Castillo
 * @version 6/11/15
 */
public class ArtModel {

    /**
     * For storing list.
     */
    private List<ShapeProperties> myShapeList;
    /**
     * constructor.
     * @param theShapes list.
     */
    public ArtModel(final List<ShapeProperties> theShapes) {
        myShapeList = new ArrayList<ShapeProperties>();
        for (ShapeProperties i: theShapes) {
            myShapeList.add(new ShapeProperties(i));
        }

    }
    /**
     * gives list.
     * @return the Shape list.
     */
    public List<ShapeProperties> getList() {
        return myShapeList;
    }
    /**
     * adds element.
     * @param theP element added.
     */
    public void add(final ShapeProperties theP) {
        myShapeList.add(theP);
    }
    /**
     * deletes at index.
     * @param theP specified index
     */
    public void remove(final ShapeProperties theP) {
        myShapeList.remove(theP);
    }
   /**
    * deletes at index.
    * @param theN specidied index
    */
    public void delete(final int theN) {
        myShapeList.remove(myShapeList.get(theN));
    }
    /**
     * Gets shapeprop at specified index.
     * @param theN index.
     * @return the shapeprop at specified index.
     */
    public ShapeProperties get(final int theN) {
        return myShapeList.get(theN);
    }
    /**
     * Gets shape at specified index.
     * @param theN index
     * @return the shape at specified index.
     */
    public Shape getShapeAt(final int theN) {
        return myShapeList.get(theN).getShape();
        
    }
    /**
     * Empties list.
     * @custom.post list is empty.
     */
    public void clear() {
        myShapeList.clear();
    }
}
