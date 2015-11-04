package Logic;

/**
 * Created by HenrikTuyen on 29/10/15.
 */
import GUI.Screen;
import SDK.ServerConnection;
import SDK.User;
import com.google.gson.Gson;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Start {

    private Screen screen;

    public Start(){
        screen = new Screen();
        screen.setVisible(true);

    }

    public void run(){
        screen.welcome.addActionListener(new WelcomeActionListener());

        screen.show(Screen.WELCOME);
    }

    private class WelcomeActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == screen.getWelcome().getBtnLogin()) {

                screen.show(Screen.MENU);

                try {

                    ServerConnection serverConnection = new ServerConnection();

                    serverConnection.get("users");

                    login("HeinHero", "321");

                } catch (Exception e1) {

                    e1.printStackTrace();

                }
            }

        }
    }

    public static void login(String username, String password){

        ServerConnection serverConnection = new ServerConnection();

        User user = new User();
        user.setPassword(password);
        user.setUsername(username);

        String json = new Gson().toJson(user);

        serverConnection.post(json, "login/");

    }


}
