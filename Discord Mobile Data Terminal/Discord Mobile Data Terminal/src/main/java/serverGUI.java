import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.ExecutionException;
import javax.swing.*;
import javax.swing.event.*;

public class serverGUI extends JPanel {
    private JButton okButton;
    private JLabel textField1;
    private JLabel textField2;
    private JTextField userID;


    static String serverid;
    public serverGUI() {
        //construct components
        okButton = new JButton ("OK");
        textField1 = new JLabel ("Server ID");
        textField2 = new JLabel ("Bot Token");
        userID = new JTextField (1);

        //adjust size and set layout
        setPreferredSize (new Dimension (526, 144));
        setLayout (null);

        //add components
        add (okButton);
        add (textField1);
        add (textField2);
        add (userID);

        //ok Button to move on

        okButton.addActionListener(e -> {
            String serverid = userID.getText();
            try {
                serverMDT.main();
            } catch (ExecutionException ex) {
                ex.printStackTrace();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        });

        //set component bounds (only needed by Absolute Positioning)
        okButton.setBounds (420, 120, 100, 20);
        textField1.setBounds (10, 15, 100, 25);
        textField2.setBounds (10, 50, 100, 25);
        userID.setBounds (70, 15, 335, 20);
    }


    public static void main () {
        JFrame frame = new JFrame ("Discord MDT v.1.0.0");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new serverGUI());
        frame.pack();
        frame.setVisible (true);
    }
}
