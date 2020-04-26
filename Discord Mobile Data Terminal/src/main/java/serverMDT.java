import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

import java.awt.*;
import java.awt.event.*;
import java.util.concurrent.ExecutionException;
import javax.swing.*;
import javax.swing.event.*;

public class serverMDT extends JPanel {

    // Objects

    private final Object String = "Arghh!";
    private JLabel serverName;
    private JLabel creationDate;
    private JLabel serverOwner;
    private JLabel memberCount;
    private JButton newQuery;
    private JLabel verificationLevel;
    private JLabel serverInvite;

    // Discord API

    static DiscordApi api = new DiscordApiBuilder().setToken("NzAzNjk5NTc3MzIwMTEyMTYw.XqT42g.F3SlPl2kDCt1FEPkGubgA48MfGw").login().join();

    // GUI

    public serverMDT() throws ExecutionException, InterruptedException {
        //construct components
        serverName = new JLabel ("Server Name: " + api.getServerById(serverGUI.serverid).get().getName());
        creationDate = new JLabel ("Date of Creation: " + api.getServerById(serverGUI.serverid).get().getCreationTimestamp());
        serverOwner = new JLabel ("Server Owner: " + api.getServerById(serverGUI.serverid).get().getOwner());
        memberCount = new JLabel ("Member Count: " + api.getServerById(serverGUI.serverid).get().getMemberCount());
        newQuery = new JButton ("New Search ");
        verificationLevel = new JLabel ("Verification Level: " + api.getServerById(serverGUI.serverid).get().getVerificationLevel());
        serverInvite = new JLabel ("Server Invite: " + api.getServerById(serverGUI.serverid).get().getInvites().get().toString());

        newQuery.addActionListener(e ->{
            mainClass.main((java.lang.String[]) String);
        });

        //adjust size and set layout
        setPreferredSize (new Dimension (519, 192));
        setLayout (null);

        //add components
        add (serverName);
        add (creationDate);
        add (serverOwner);
        add (memberCount);
        add (newQuery);
        add (verificationLevel);
        add (serverInvite);

        //set component bounds (only needed by Absolute Positioning)
        serverName.setBounds (5, 5, 100, 25);
        creationDate.setBounds (5, 30, 100, 25);
        serverOwner.setBounds (5, 55, 100, 25);
        memberCount.setBounds (5, 80, 100, 25);
        newQuery.setBounds (390, 155, 120, 30);
        verificationLevel.setBounds (5, 105, 115, 25);
        serverInvite.setBounds (5, 130, 100, 25);
    }


    public static void main () throws ExecutionException, InterruptedException {
        JFrame frame = new JFrame ("Discord MDT search on " + api.getServerById(serverGUI.serverid).get().getName());
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add (new serverMDT());
        frame.pack();
        frame.setVisible (true);
    }
}
