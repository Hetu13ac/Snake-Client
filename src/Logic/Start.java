package Logic;

/**
 * Created by HenrikTuyen on 29/10/15.
 */
import GUI.Screen;

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

    private class WelcomeActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (e.getSource() == screen.getWelcome().getBtnLogin())
            {
                screen.show(Screen.MENU);
            }

        }
    }

}
