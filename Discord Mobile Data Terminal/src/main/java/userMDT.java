import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.ExecutionException;
import javax.swing.*;
import javax.swing.event.*;

public class userMDT extends JPanel {

    // Objects

    private final Object String = "Arghh!";
    private JLabel userName;
    private JLabel creationDate;
    private JLabel status;
    private JLabel bot;
    private JButton newQuery;

    // Discord API

    static DiscordApi api = new DiscordApiBuilder().setToken("NzAzNjk5NTc3MzIwMTEyMTYw.XqT42g.F3SlPl2kDCt1FEPkGubgA48MfGw").login().join();

    // GUI

    public userMDT() throws ExecutionException, InterruptedException {

        //construct components
        userName = new JLabel ("Username: " + api.getUserById(userGUI.userid).get().getDiscriminatedName());
        creationDate = new JLabel ("Date of Creation: " + api.getUserById(userGUI.userid).get().getCreationTimestamp());
        status = new JLabel ("User Status: " + api.getUserById(userGUI.userid).get().getStatus());
        if(api.getUserById(userGUI.userid).get().isBot()){
            bot = new JLabel ("isBot: TRUE");
        } else {
            bot = new JLabel ("isBot: FALSE");
        }
        newQuery = new JButton ("New Search");

        newQuery.addActionListener(e ->{
            mainClass.main((java.lang.String[]) String);
        });

        //adjust size and set layout
        setPreferredSize (new Dimension (519, 138));
        setLayout (null);

        //add components
        add (userName);
        add (creationDate);
        add (status);
        add (bot);
        add (newQuery);

        //set component bounds (only needed by Absolute Positioning)
        userName.setBounds (5, 5, 100, 25);
        creationDate.setBounds (5, 30, 100, 25);
        status.setBounds (5, 55, 100, 25);
        bot.setBounds (5, 80, 100, 25);
        newQuery.setBounds (395, 105, 120, 30);
    }


    public static void main () throws ExecutionException, InterruptedException {
        JFrame frame = new JFrame ("Discord MDT search on " + api.getUserById(userGUI.userid).get().getDiscriminatedName());
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new userMDT());
        frame.pack();
        frame.setVisible (true);
    }
}