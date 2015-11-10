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

public class Start
{

    private Screen screen;

    public Start()
    {
        screen = new Screen();
        screen.setVisible(true);
    }

    public void run()
    {
        screen.welcome.addActionListener(new WelcomeActionListener());
        screen.menu.addActionListener(new MenuActionListener());
        screen.signUp.addActionListener(new SignUpActionListener());

        screen.show(Screen.WELCOME);
    }

    private class WelcomeActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {

            if(e.getSource() == screen.getWelcome().getBtnLogin())
            {
                if (userAuth())
                {
                    screen.show(Screen.MENU);
                    screen.getWelcome().clearTextFields();
                }

            }
            if(e.getSource() == screen.getWelcome().getBtnSignUp())
            {
                screen.show(Screen.SIGNUP);
            }
        }


        public boolean userAuth()
        {

            String username = screen.getWelcome().getUsername();
            String password = screen.getWelcome().getPassword();

            ServerConnection serverConnection = new ServerConnection();

            User user = new User();
            user.setPassword(password);
            user.setUsername(username);

            String json = new Gson().toJson(user);

            String message = serverConnection.stringMessageParser(serverConnection.post(json, "login/"));
            System.out.println(message);

            if (message.equals("Login successful"))
            {
                screen.getWelcome().getLblAccessDenied().setVisible(false);
                return true;
            }
            else if(message.equals("Wrong username or password") || message.equals("Error in JSON")) {

                screen.getWelcome().getLblAccessDenied().setVisible(true);
            }

            return false;
        }
    }

    private class SignUpActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (e.getSource() == screen.getSignUp().getBtnSignUp())
            {
                screen.getSignUp().getSuccesfulCreate().setVisible(true);
            }
            if (e.getSource() == screen.getSignUp().getBtnBack())
            {
                screen.show(Screen.WELCOME);
                screen.getSignUp().getSuccesfulCreate().setVisible(false);
            }

        }
    }

    private class MenuActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (e.getSource() == screen.getMenu().getBtnLogOff())
            {
                screen.show(Screen.WELCOME);
                System.out.println("Logging off the system");
            }

        }
    }
}

