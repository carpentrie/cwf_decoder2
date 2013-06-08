import javax.swing.*;

/**
 * Created with IntelliJ IDEA.
 * User: nanomonk
 * Date: 08.06.13
 * Time: 9:57
 * To change this template use File | Settings | File Templates.
 */
public class Decoder {
    public static void main(String[] args){
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                JFrame.setDefaultLookAndFeelDecorated(true);
                JDialog.setDefaultLookAndFeelDecorated(true);
                //Create and set up the window.
                JFrame frame = new JFrame("SpringForm");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setContentPane(new DecoderForm());

                //Display the window.
                frame.pack();
                frame.setVisible(true);
            }
        });
    }
}
