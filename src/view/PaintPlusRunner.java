
package view;

import java.awt.EventQueue;

import javax.swing.JFrame;


/**
 * Project 2.
 * TCSS 305
 * @author Athena Castillo
 * @version 6/11/15
 */
public final class PaintPlusRunner {

    /**
     * Private constructor to inhibit instantiation.
     */
    private PaintPlusRunner() {
        throw new IllegalStateException();
    }

    /**
     * Start point for the program.
     * 
     * @param theArgs command line arguments - ignored
     */
    public static void main(final String... theArgs) {

        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                final JFrame frame = new ArtFrame();
                frame.setTitle("Paint");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }

}
