
package view;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.Path2D;
import java.awt.geom.Point2D;
import java.awt.geom.RectangularShape;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import model.ArtModel;
import model.ShapeProperties;
import controller.AbstractAnimation;
import controller.Animation1;
import controller.Animation2;
import controller.ArcMouser;
import controller.CircleMouser;
import controller.RectangleMouser;

/**
 * Project 2.
 * TCSS 305
 * @author Athena Castillo
 * @version 6/11/15
 */
public class ArtPanel extends JPanel {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /** A ToolKit. */
    private static final Toolkit KIT = Toolkit.getDefaultToolkit();

    /** The Dimension of the screen. */
    private static final Dimension SCREEN_SIZE = KIT.getScreenSize();

    /** The width of the screen. */
    private static final int SCREEN_WIDTH = (int) (SCREEN_SIZE.width * 0.50);

    /** The height of the screen. */
    private static final int SCREEN_HEIGHT = (int) (SCREEN_SIZE.height * 0.50);

    /** The default size for this JPanel. */
    private static final Dimension DEFUALT_SIZE = new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT);
    /**
     * The first point.
     */
    private Point myP1;
    /**
     * The second point.
     */
    private Point myP2;
    /**
     * Keeps track of the shapes drawn.
     */
    private List<ShapeProperties> myShapesList;
    /**
     * Path where the line is being drawn.
     */
    private GeneralPath myDoodle;
    /**
     * list used for drawing the free draw.
     */
    private List<ShapeProperties> myDoodleList;
    /**
     * color used for shapes.
     */
    private Color myColor; 
    /**
     * model for handling a list.
     */
    private ArtModel myArtMod;
    /**
     * flag for fill.
     */
    private boolean myFlag;
    /**
     * default adapter.
     */
    private final MouseAdapter myDefaultAdapter;
    /**
     * current adapter being used.
     */
    private MouseAdapter myCurrentAdapter;
    /**
     * circle mouse.
     */
    private final CircleMouser myCircle;
    /**
     * stroke.
     */
    private int myStroke;
    /**
     * timer for animation.
     */
    private Timer myTimer;
    /**
     * animation 1.
     */
    private ActionListener myAnime1;
    /**
     * animation 2.
     */
    private ActionListener myAnime2;
    /**
     * the Current animation thats been set.
     */
    private ActionListener myCurrentAnime;
    /**
     * rectangle mouser.
     */
    private final RectangleMouser myRect;
    /**
     * number of mouse clicks.
     */
    private int myMouseClicks;
    /**
     * int for finding the shape that is clicked.
     */
    private int myMove;
    /**
     * if a shape is clicked.
     */
    private boolean myFlag2;
    /**
     * used for moving around general path.
     */
    private AffineTransform myTransForm;
    /**
     * new x of general path.
     */
    private double myPathX;
    /**
     * new y of general path.
     */
    private double myPathY;
    /**
     * mouseadapter for arc.
     */
    private ArcMouser myArc;
    /**
     * boolean for activating mirror paint.
     */
    private boolean myMirror;
    /**
     * general path for mirror.
     */
    private GeneralPath myDoodle2;
    /**
     * Construct this JPanel.
     * @custom.post white panel 
     */
    public ArtPanel() {
        super();
        setPreferredSize(DEFUALT_SIZE);
        setBackground(Color.WHITE);
        myColor = Color.BLACK;
        myP1 = new Point();
        myP2 = new Point();
        myShapesList = new ArrayList<ShapeProperties>();
        myDoodleList = new ArrayList<ShapeProperties>();
        myArtMod = new ArtModel(myShapesList);
        myDefaultAdapter = new Mouser();
        myCurrentAdapter = myDefaultAdapter;
        myAnime1 = new Animation1(this, myArtMod);
        myAnime2 = new Animation2(this, myArtMod);
        myCurrentAnime = myAnime2;
        myRect = new RectangleMouser(this, myArtMod, myColor, myFlag, myDoodleList);
        myCircle = new CircleMouser(this, myArtMod, myColor, myFlag, myDoodleList);
        myArc = new ArcMouser(this, myArtMod, myColor, myFlag, myDoodleList);
        myTimer = new Timer(1, myAnime2);
        myTimer.setDelay(5);
        //myMirror = false;
        addMouseListener(myCurrentAdapter);
        addMouseMotionListener(myCurrentAdapter);
        addMouseListener(new MouseMove());
        addMouseMotionListener(new MouseMove());
        
    }
    /**
     * activates the mirror paint.
     */
    public void activateMirror() {
        removeMouseListener(myCurrentAdapter);
        removeMouseMotionListener(myCurrentAdapter);
        myCurrentAdapter = myDefaultAdapter;
        addMouseListener(myDefaultAdapter);
        addMouseMotionListener(myDefaultAdapter);
        myMirror = true;
    }
    /**
     * returns myDefaultAdapter.
     * @return gives defaulatadapter.
     */
    public MouseAdapter defaultMouser() {
        myMirror = false;
        return myDefaultAdapter;
    }
    /**
     * returns myArc.
     * @return gives arc mouser.
     */
    public MouseAdapter arcMouser() {
        return myArc;
    }
    /**
     * gives rectangle adapter.
     * @return gives the rectangle adaptator.
     */
    public MouseAdapter rectangleMouser() {
        return myRect;
        
    }
    /**
     * returns myCircle.
     * @return gives circle adapter.
     */
    public MouseAdapter circleMouser() {
        return myCircle;
    }
    /**
     * gives variable myAnime2.
     * @return gives animatation 1
     */
    public ActionListener animation1() {
        return myAnime1;
        
    }
    /**
     * gives variable myAnime2.
     * @return gives animation2
     */
    public ActionListener animation2() {
        return myAnime2;
    }
    /**
     * sets up timer.
     * @param theL actionlistener the timer is being set up to.
     */
    public void setTimer(final ActionListener theL) {
        myTimer.stop();
        myTimer = new Timer(5, theL);
        myCurrentAnime = theL;
        //mytimer.start();
        
    }
    /**
     * resets the color.
     * @param theC color being set.
     */
    public void setColor(final Color theC) {
        myColor = theC;
        myRect.setColor(theC);
        myCircle.setColor(theC);
        myArc.setColor(theC);
        
    }
    /**
     * sets the flag.
     * @param theB boolean being set.
     * @custom.post myFlag = theB
     */
    public void setFlag(final boolean theB) {
        myFlag = theB;
        myRect.setFlag(theB);
        myCircle.setFlag(theB);
        myArc.setFlag(theB);
    }
    /**
     * sets the stroke.
     * @param theS being set.
     */
    public void setStroke(final int theS) {
        //System.out.println("set Stroke in art panel");
        myStroke = theS;
        System.out.println("curren Stroke: " + theS);
        myRect.setStroke(theS);
        myCircle.setStroke(theS);
        myArc.setStroke(theS);
        
    }
    /**
     * resets the mouse listener.
     * @param theM MouseAdater that is being set.
     * @custom.post theM now added.
     */
    public void resetMouseListener(final MouseAdapter theM) {
        removeMouseListener(myCurrentAdapter);
        removeMouseMotionListener(myCurrentAdapter);
        myCurrentAdapter = theM;
        addMouseListener(theM);
        addMouseMotionListener(theM);
        myMirror = false;
        
    }
    /**
     * starts timer.
     * @custom.post timer started.
     */
    public void timerStart() {
        myTimer.start();
    }
    /**
     * pauses timer.
     * @custom.post timer stoped.
     */
    public void timerStop() {
        myTimer.stop();
    }
    /**
     * clears the panel.
     * @custom.post panel cleared.
     */
    public void clear() {
        myArtMod.clear();
        repaint();
    }
    /**
     * Stops the timer.
     * @custom.post timer stoped.
     */
    public void stop() {
        myTimer.stop();
        for (ShapeProperties i: myArtMod.getList()) {
            if (i.getShape() instanceof RectangularShape) {
                ((RectangularShape) i.getShape()).setFrame(i.getOriginalX(),
                                                           i.getOriginalY(),
                                                           ((RectangularShape) 
                                                            i.getShape()).getWidth(),
                                                           ((RectangularShape)
                                                            i.getShape()).getHeight());
            }
        }
        repaint();
    }
    /**
     * steps foward the animation.
     * @custom.post one frame is played.
     */
    public void doFastForward() {

        myTimer.stop();

        ((AbstractAnimation) myCurrentAnime).fastForward();

    }
    /**
     * sets the speed.
     * @param theSpeed speed being set.
     */
    public void setSpeed(final int theSpeed) {
        final int speed = 20 - theSpeed;
        myTimer.setDelay(speed);
       
        
    }
    /**
     * draws on the panel.
     * @param thePen graphic that is drawing.
     * @custom.post shapes drawin in java.
     */
    @Override
    public void paintComponent(final Graphics thePen) {
        super.paintComponent(thePen);
        final Graphics2D pen = (Graphics2D) thePen;
    
        myShapesList = myArtMod.getList();
      
       
       
        for (ShapeProperties i : myArtMod.getList()) {

            pen.setColor(i.getColor());
            pen.setStroke(i.getStroke());
            
            
            if (i.getTrans() != null && !(i.getShape() instanceof RectangularShape)) {
         
                
                ((Path2D) i.getShape()).transform(i.getTrans());
            }
            
            pen.draw(i.getShape());
          
            if (i.getFlag()) {
                pen.fill(i.getShape());
            }
            if (i.getShape() instanceof Path2D) {
                i.setTransform(null);
            }
            
        }
        for (ShapeProperties i : myDoodleList) {
            pen.setColor(i.getColor());
            pen.setStroke(i.getStroke());
            pen.draw(i.getShape());
            if (i.getFlag()) {
                pen.fill(i.getShape());
            }
        }
        myDoodleList.clear();

        pen.setStroke(new BasicStroke(myStroke));
       

        if (myDoodle != null) {
            pen.setStroke(new BasicStroke(myStroke));
            pen.setColor(myColor);
            pen.draw(myDoodle);
            
        }
        if (myDoodle2 != null) {
            pen.setStroke(new BasicStroke(myStroke));
            pen.setColor(myColor);
            pen.draw(myDoodle2);
            
        }
   
        
    }
    /**
     * 
     */
    private class Mouser extends MouseAdapter {
        
        /**
         * Where the doodle starts.
         * @param theEvent where the mouse is pressed.
         */
        @Override
        public void mousePressed(final MouseEvent theEvent) {

            myP1.setLocation(theEvent.getX(), theEvent.getY());
            myP2.setLocation(theEvent.getX(), theEvent.getY());
            
            
            if (SwingUtilities.isLeftMouseButton(theEvent)) {
                myDoodle = new GeneralPath();
                myDoodle.moveTo(myP1.getX(), myP1.getY());
                myDoodle2 = new GeneralPath();
                myDoodle2.moveTo(getWidth() - myP1.getX(), myP1.getY());
            } else {
                myDoodle = null;
            }


        }
        /**
         * @param theEvent the even happening.
         * @custom.post Shape added once mouse is released.
         */
        @Override
        public void mouseReleased(final MouseEvent theEvent) {

            if (myDoodle != null) {
                final ShapeProperties shape = new ShapeProperties(myDoodle, myColor);
                shape.setStroke(myStroke);
     
                myArtMod.add(shape);
                if(myMirror && myDoodle2 != null){
                    final ShapeProperties s = new ShapeProperties(myDoodle2, myColor);
                    s.setStroke(myStroke);
                    myArtMod.add(s);
                }
                

            }
            //;
            myDoodle2 = null;
            myDoodle = null;


        }

        /**
         * Creats the line as the mouse is dragged.
         * @param theEvent the event happening.
         */
        public void mouseDragged(final MouseEvent theEvent) {

            myP1.setLocation(theEvent.getX(), theEvent.getY());

            myP2.setLocation(theEvent.getX(), theEvent.getY());
            final Line2D.Double line =
                            new Line2D.Double(myP1.getX(), myP1.getY(), myP2.getX(),
                                              myP2.getY());
            final Line2D.Double line2 =  new Line2D.Double( getWidth() -myP1.getX(), 
                                                             myP1.getY() , 
                                                            getWidth() - myP2.getX() ,
                                                           myP2.getY() );
            
            if (myDoodle != null && !myMirror) {
                myDoodle.append(line, true);
            } else if(myDoodle != null && myMirror && myDoodle2 != null){
                myDoodle.append(line, true);
                myDoodle2.append(line2, true);
            }
        
            //myArtMod.add(new ShapeProperties(line, color));
            repaint();
        }

    }
  
    /**
     * 
     * @author athenac
     *
     */
    private class MouseMove extends MouseAdapter {
        // int mouseClicks;
        @Override
        public void mousePressed(final MouseEvent theEvent) {
            myFlag = true;
            myP1.setLocation(theEvent.getX(), theEvent.getY());
            myP2.setLocation(theEvent.getX(), theEvent.getY());
            
            // mouseClicks ++;
            if (SwingUtilities.isRightMouseButton(theEvent)) {

                for (int i = 0; i < myArtMod.getList().size(); i++) {
                    // myMove ++;

                    if (myArtMod.getShapeAt(i).contains(theEvent.getX(), theEvent.getY())) {
                        myFlag2 = true;
                        myMove = i;
                        // System.out.println("h");
                        //break;

                    }

                }

            }
        }       
        @Override    
        public void mouseReleased(final MouseEvent theEvent) {
            myMove = 0;
            myFlag2 = false;
            myTransForm = null;
            
        }
        @Override
        public void mouseClicked(final MouseEvent theEvent) {
            if (SwingUtilities.isRightMouseButton(theEvent)) {
                myMouseClicks++;
                // System.out.println("mouseClicks = 2");
            }
            if (myMouseClicks >= 2) {
                int k = 0;
                System.out.println("mouseClicks = 2 passed first if");
                for (int i = 0; i < myArtMod.getList().size(); i++) {
                    if (myArtMod.getShapeAt(i).contains(theEvent.getX(), theEvent.getY())) {
                        //myArtMod.delete(i);
                        k = i;
                        //break;
                    }

                }
                myArtMod.delete(k);
                myMouseClicks = 0;
                System.out.println("mouseClicks = 2 passed 2nd if");
            }
            repaint();

        }

        
        @Override
        public void mouseDragged(final MouseEvent theEvent) {
            
            if (myFlag2 && SwingUtilities.isRightMouseButton(theEvent) && myMouseClicks < 2) {
                double w;
                double h;
                if (myArtMod.getShapeAt(myMove) instanceof RectangularShape) {
                    final Shape s = (RectangularShape) myArtMod.getShapeAt(myMove);
                    w = ((RectangularShape) s).getWidth() / 2;
                    h = ((RectangularShape) s).getHeight() / 2;
                    ((RectangularShape) s).setFrame(
                                                    theEvent.getX() - w,
                                                    theEvent.getY() - h,
                                                    ((RectangularShape) s).getWidth(),
                                                    ((RectangularShape) s).getHeight());
                    //System.out.println("j");
                } else if (myArtMod.getShapeAt(myMove) instanceof GeneralPath) {
                   
                    final Point2D current = ((GeneralPath) myArtMod.getShapeAt(myMove)).
                                    getCurrentPoint();
                    final double newX = theEvent.getX() - current.getX();
                    final double newY = theEvent.getY() - current.getY();
                    System.out.println(current.getX());
                    myPathX = newX;
                    myPathY = newY;
                
                    System.out.println("transform");
                    myTransForm = AffineTransform.getTranslateInstance(myPathX, myPathY);
                    myArtMod.get(myMove).setTransform(myTransForm);
                   
                   
                }
            }
            //repaint();
            repaint();

        }
       


    }


}
