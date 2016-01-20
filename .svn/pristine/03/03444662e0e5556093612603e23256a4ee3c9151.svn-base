package view;

import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JToggleButton;

/**
 * Project 2.
 * TCSS 305
 * @author Athena Castillo
 * @version 6/11/15
 */
public class ShapeTools extends JPanel {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * rectangel button.
     */
    private JToggleButton myRect;
    /**
     * circle button.
     */
    private JToggleButton myCircle;
    /**
     * arc button.
     */
    private JToggleButton myArc;
    /**
     * line button.
     */
    private JToggleButton myLines;
    /**
     * Button for mirror.
     */
    private JToggleButton myMirror;
    /**
     * group button.
     */
    private final ButtonGroup myGroup;
    /**
     * array of Stroke sizes.
     */
    private Integer[] myStrokeSize = new Integer[100];
    /**
     * Combobox for stroks.
     */
    private JComboBox<Integer> myStrokeList;
    /**
     * checkbox for fill.
     */
    private JCheckBox myFillCheck;
    /**
     * constructor.
     * @param theActions for JtoggleButtons.
     */
    public ShapeTools(final Action[] theActions) {
        myRect = new JToggleButton(theActions[0]);
        myCircle = new JToggleButton(theActions[1]);
        myArc = new JToggleButton(theActions[2]);
        myLines = new JToggleButton(theActions[3]);
        myMirror = new JToggleButton(new ImageIcon("12-mirror-icon.png"));
        myGroup = new ButtonGroup();
        setUpButtons();
    }
    /**
     * sets up the buttons.
     */
    public void setUpButtons() {
        makeArray();
        myStrokeList = new JComboBox<Integer>(myStrokeSize);
        setUpSize();
        myFillCheck = new JCheckBox("fill");
        add();
        setPreferredSize(new Dimension(50, 50));
      
    }
    /**
     * adds buttons.
     */
    private void add() {
        myGroup.add(myRect);
        myGroup.add(myCircle);
        myGroup.add(myArc);
        myGroup.add(myLines);
        myGroup.add(myMirror);
        add(myMirror);
        add(myLines);
        add(myRect);
        add(myCircle);
        add(myArc);
        add(myStrokeList);
        add(myFillCheck);
    }
    /**
     * makes array.
     * @custom.post myStrokeSize contains integers to 100.
     */
    private void makeArray() {
        for (int i = 0; i < 100; i++) {
            myStrokeSize[i] = i;                  
        }
    }
    /**
     * gives check box for fill.
     * @return gives checkbox for fill.
     */
    public JCheckBox getCheckBox() {
        return myFillCheck;
    }
    /**
     * setting up fill.
     * @param theList listener being added.
     */
    public void setFillListener(final ActionListener theList) {
        myFillCheck.addActionListener(theList);
    }
    /**
     * setting up stroke.
     * @param theListener listener being added.
     */
    public void setStrokeListener(final ActionListener theListener) {
        myStrokeList.addActionListener(theListener);
    }
    /**
     * gives strokes.
     * @return gives strokes.
     */
    public JComboBox<Integer> getStrokes() {
        return myStrokeList;
    }
    /**
     * sets up size of strokelist.
     */
    private void setUpSize() {
        myStrokeList.setMinimumSize(new Dimension(40, 30));
        myStrokeList.setMaximumSize(new Dimension(40, 30));
    }
    /**
     * sets up mirror action.
     * @param theL actioListener.
     */
    public void setMirrorActions(final ActionListener theL){
        myMirror.addActionListener(theL);
    }

}
