/**
 * 
 */
package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *  * Project 2.
 * TCSS 305
 * @author Athena Castillo
 * @version 6/11/15
 */
@SuppressWarnings("serial")
public class MenuBar extends JMenuBar {

    /** The File menu. */
    private final JMenu myFileMenu;
    /**
     * Saves file.
     */
    private final JMenuItem mySaveButton;
    /**
     * clears panel.
     */
    private final JMenuItem myClear;
    /**
     * picks file.
     */
    private JFileChooser myFilePicker;
    /**
     * panel using.
     */
    private JPanel myPanel;
    /**
     * saves file as image.
     */
    private BufferedImage myImage;
    /**
     * Construct the menu bar.
     * @param thePanel panel being made.
     * @custom.post all menu bar elements constructed
     */
    public MenuBar(final JPanel thePanel) {     
        super();
        myPanel = thePanel;
        myFileMenu = new JMenu("File");
        myClear = new JMenuItem("New");
        mySaveButton = new JMenuItem("Save");
        myFilePicker = new JFileChooser();
        clearAction();
        setUpFiles();
        saveAction();
        addStuff();
    }
    /**
     * adds menu stuff.
     */
    public void addStuff() {
        add(myFileMenu);
        myFileMenu.add(myClear);
        myFileMenu.add(mySaveButton);
        
    }
    /**
     * sets up file filter.
     */
    public void setUpFiles(){
        final FileFilter filter = new FileNameExtensionFilter(".jpg", "jpg");
        final FileFilter png = new FileNameExtensionFilter(".png", "png");
        final FileFilter gif = new FileNameExtensionFilter(".gif", "gif");
        myFilePicker.addChoosableFileFilter(filter);
        myFilePicker.addChoosableFileFilter(png);
        myFilePicker.addChoosableFileFilter(gif);
    }
    /**
     * save action.
     */
    public void saveAction() {
        myImage = null;
        mySaveButton.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                // BufferedImage image = null;

                final int choice = myFilePicker.showSaveDialog(myPanel);
                if (choice == JFileChooser.APPROVE_OPTION) {
                    try {

                        final File file = new File(myFilePicker.getSelectedFile().getPath()
                                          + myFilePicker.getFileFilter().getDescription());

                        if (!file.exists()) {
                            file.createNewFile();

                        }
                        myImage = new BufferedImage(myPanel.getWidth(), myPanel.getHeight(), 
                                                  BufferedImage.TYPE_INT_RGB);
                        myPanel.print(myImage.getGraphics());
                        if (myFilePicker.getFileFilter().
                                        getDescription().equals(".jpg")) {
                            ImageIO.write(myImage, "jpg", file);
                        
                        } else if (myFilePicker.getFileFilter().
                                        getDescription().equals(".png")) {
                            ImageIO.write(myImage, "png", file);
                       
                        } else if (myFilePicker.getFileFilter().
                                        getDescription().equals(".gif")) {
                            ImageIO.write(myImage, "gif", file);
                        }

                    
                    } catch (final IOException exception) {
                        JOptionPane.showMessageDialog(myPanel, "Oops! File error!");
                    }

                }
            }
        });
    }
    /**
     * clear action.
     */
    public void clearAction() {
        myClear.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent theE) {
                ((ArtPanel) myPanel).clear();
                
            }
            
        });
    }

}

