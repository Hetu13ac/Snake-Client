package Logic;

/**
 * Created by HenrikTuyen on 29/10/15.
 */

import GUI.Screen;
import SDK.ServerConnection;
import SDK.User;
import com.google.gson.Gson;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;

public class Start {

    private Screen screen;

    public Start() {

        screen = new Screen();
        screen.setVisible(true);

    }

    public void run() {
        screen.welcome.addActionListener(new WelcomeActionListener());
        screen.show(Screen.WELCOME);
    }

    private class WelcomeActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == screen.getWelcome().getBtnLogin()) {
                if (userAuth()) {
                    screen.show(Screen.MENU);
                }

                /*try {

                    ServerConnection serverConnection = new ServerConnection();

                    serverConnection.get("users");

                } catch (Exception e1) {

                    e1.printStackTrace();

                }*/
            }

        }
    }

    public static void login(String username, String password) {

        ServerConnection serverConnection = new ServerConnection();

        User user = new User();
        user.setPassword(password);
        user.setUsername(username);

        String json = new Gson().toJson(user);

        serverConnection.post(json, "login/");

    }


    public boolean userAuth() {

        String username = screen.getWelcome().getUsername();
        String password = screen.getWelcome().getPassword();

        ServerConnection serverConnection = new ServerConnection();

        User user = new User();
        user.setPassword(password);
        user.setUsername(username);

        String json = new Gson().toJson(user);

        String message = stringMessageParser(serverConnection.post(json, "login/"));
        System.out.println(message);

        if (message.equals("Login successful")) {
            return true;
        }
        else {
            //lav nogle Jlabels som giver nogle fejlbeskeder
        }

        return false;
    }


    public String stringMessageParser(String json)
    {
        JSONParser jsonParser = new JSONParser();

        String message = "";
        try
        {
            Object obj = jsonParser.parse(json);
            JSONObject jsonObject = (JSONObject) obj;

            message = ((String) jsonObject.get("message"));

        } catch (ParseException e)
        {
            e.printStackTrace();
        }
        return message;

    }
}

