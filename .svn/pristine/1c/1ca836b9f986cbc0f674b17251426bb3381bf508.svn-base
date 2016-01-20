package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
/**
 * Project 2.
 * TCSS 305
 * @author Athena Castillo
 * @version 6/11/15
 */
public class ArtFrame extends JFrame {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /** A ToolKit. */
    private static final Toolkit KIT = Toolkit.getDefaultToolkit();
    
    /** The Dimension of the screen. */
    private static final Dimension SCREEN_SIZE = KIT.getScreenSize();
    
    /** The width of the screen. */
    private static final int SCREEN_WIDTH = (int) (SCREEN_SIZE.width * 0.80);
    /** The height of the screen. */
    private static final int SCREEN_HEIGHT = (int) (SCREEN_SIZE.height * 0.80);
    /**
     * art panel.
     */
    private ArtPanel myArt;;
    /**
     * Art choices.
     */
    private ArtChoices myArtChoices;
    /**
     * Animation buttons.
     */
    private AnimationButtons myAnime;
    /**
     * menuBar.
     */
    private MenuBar myMenu;
    /**
     * constructor.
     */
    public ArtFrame() {

        myArt = new ArtPanel();
        myArtChoices = new ArtChoices(myArt);
        myAnime = new AnimationButtons(myArt);
        myMenu = new MenuBar(myArt);
        
        setUpMenu();
        // TODO Auto-generated constructor stub
    }
    /**
     * sets up panel.
     */
    private void setUpMenu() {
        setJMenuBar(myMenu);
        //setJMenuBar(myArtChoices.getMenu());
        add(myArtChoices.getToolBar(), BorderLayout.WEST);
        add(myArt);
        add(myAnime, BorderLayout.NORTH);
        add(myArtChoices, BorderLayout.SOUTH);
        
        setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
    }

}
