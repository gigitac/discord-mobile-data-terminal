import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;

import javax.swing.*;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Scanner inputSystem = new Scanner(System.in);
        System.out.println("Discord Mobile Data Terminal");
        System.out.println("Developed by gigitac#8656");
        System.out.println("You need a bot token to use this.");

        // ID Info
        System.out.println("Input bot token.");
        String bottoken = inputSystem.nextLine();
        System.out.println("Input userID");
        String userid = inputSystem.nextLine();
        DiscordApi api = new DiscordApiBuilder().setToken(bottoken).login().join();

        // Strings
        String username = ("Username: " + api.getUserById(userid).get().getDiscriminatedName());
        String creationDate = ("Date of Creation: " + api.getUserById(userid).get().getCreationTimestamp());
        String userStatus = ("User Status: " + api.getUserById(userid).get().getStatus().toString());
        String isBot = ("null");
        if (api.getUserById(userid).get().isBot()) {
            isBot = ("isBot: TRUE");
        } else {
            isBot = ("isBot: FALSE");
        }

        System.out.println(username);
        System.out.println(creationDate);
        System.out.println(userStatus);
        System.out.println(isBot);

    }
}

