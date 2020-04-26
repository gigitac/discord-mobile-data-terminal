import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class mainClass extends JPanel {
    private JButton searchUser;
    private JLabel jcomp2;
    private JButton searchServer;

    public mainClass() {
        //construct components
        searchUser = new JButton("Search User by ID");
        jcomp2 = new JLabel("Select an Option");
        searchServer = new JButton("Search Server by ID");

        //adjust size and set layout
        setPreferredSize(new Dimension(483, 72));
        FlowLayout layout = new FlowLayout();
        layout.setHgap(5);
        layout.setVgap(25);
        setLayout(layout);

        //add components
        add(searchUser);
        add(jcomp2);
        add(searchServer);

        searchServer.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                serverGUI.main();
            }
        });

        searchUser.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                userGUI.main();
            }
        });
    }


    public static void main(String[] args) {
        JFrame frame = new JFrame("Discord MDT v.1.0.0");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new mainClass());
        frame.pack();
        frame.setVisible(true);
    }
}
