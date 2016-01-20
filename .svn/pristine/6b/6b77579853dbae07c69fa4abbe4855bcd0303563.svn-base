/**
 * 
 */
package view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JToolBar;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import controller.AnimationActions;

/**
 * Project 2.
 * TCSS 305
 * @author Athena Castillo
 * @version 6/11/15
 */
public class AnimationButtons extends JToolBar {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * panel.
     */
    private final ArtPanel myPanel;
    /**
     * foward button.
     */
    private JButton myFowardMotion;
    /**
     * updown button.
     */
    private JButton myUpDown;
    /**
     * play button.
     */
    private JButton myPlay;
    /**
     * pause button.
     */
    private JButton myPause;
    /**
     * speed adjustment.
     */
    private JSlider mySpeed;
    /**
     * foward button.
     */
    private JButton myFoward;
    /**
     * stop button.
     */
    private JButton myStop;
    /**
     * label for slider.
     */
    private JLabel myLabel;
    /**
     * for slider and label.
     */
    private Box myAnimeBox;
    /**
     * 
     * @param thePanel the panel being animated on.
     */
    public AnimationButtons(final JPanel thePanel) {
        myPanel = (ArtPanel) thePanel;
        creatAnimations();
        createButtons();
        mySpeed = new JSlider(1,20);
        myLabel = new JLabel("Feedback");
        myAnimeBox = Box.createVerticalBox();
        setUp();
        
        // TODO Auto-generated constructor stub
    }
    /**
     * sets up animation buttons.
     */
    public void setUp(){
        
        setSize();
        fastFoward();
        stop();
        addSliderActions();
        addPlayPauseActions();
        addButtons();
    }
    /**
     * sets the size.
     */
    public void setSize() {
        mySpeed.setMinimumSize(new Dimension(200, 30));
        mySpeed.setMaximumSize(new Dimension(200, 30));
    }
    /**
     * creates buttons.
     */
    public void createButtons() {
        myPlay = new JButton(new ImageIcon("play.png"));
        myPause = new JButton(new ImageIcon("pause .png"));
        myFoward = new JButton(new ImageIcon("step-forward.png"));
        myStop = new JButton(new ImageIcon("stop.png"));
    }
    /**
     * creates animations.
     */
    public void creatAnimations() {
        myFowardMotion = new JButton(new AnimationActions(myPanel, null, 
                                                          myPanel.animation1()));
        myUpDown = new JButton(new AnimationActions(myPanel, null, myPanel.animation2()));
        myFowardMotion.setText("Foward and Back");
        myUpDown.setText("up and down");
    }
    /**
     * adds buttons.
     */
    public void addButtons() {
        myAnimeBox.add(myLabel);
        myAnimeBox.add(mySpeed);
        add(myFowardMotion);
        add(myUpDown);
        add(myAnimeBox);
        add(myPlay);
        add(myPause);
        add(myFoward);
        add(myStop);
    }
    /**
     * adds adds slider actions.
     */
    public void addSliderActions() {
        mySpeed.addChangeListener(new ChangeListener() {

            @Override
            public void stateChanged(final ChangeEvent theE) {
                // TODO Auto-generated method stub
                myPanel.setSpeed(mySpeed.getValue());
            }
            
        });
    }
    /**
     * creats play buttons.
     */
    public void addPlayPauseActions() {
        myPlay.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent theE) {
                myPanel.timerStart();
                
            }
            
        });
        myPause.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                // TODO Auto-generated method stub
                myPanel.timerStop();
            }
            
        });
    }
    /**
     * creates fastfoward acition.
     */
    public void fastFoward() {
        myFoward.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent theEvent) {
                myPanel.doFastForward();

            }


        });
    }
    /**
     * creates stop action.
     */
    public void stop() {
        myStop.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent theE) {
                myPanel.stop();
                
            }
            
        });
    }
    

}
