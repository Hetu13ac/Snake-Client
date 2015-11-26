package Logic;

/**
 * Created by HenrikTuyen on 29/10/15.
 */

import GUI.Screen;
import SDK.*;
import com.google.gson.Gson;

import javax.swing.table.AbstractTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.ArrayList;

public class Start
{
    private Screen screen;
    private ServerConnection serverConnection;
    private Api api;
    private User currentUser;

    public Start()
    {
        screen = new Screen();
        screen.setVisible(true);
        serverConnection = new ServerConnection();
        api = new Api();
    }

    public void run()
    {
        screen.welcome.addActionListener(new WelcomeActionListener());
        screen.menu.addActionListener(new MenuActionListener());
        screen.signUp.addActionListener(new SignUpActionListener());
        screen.newGame.addActionListener(new NewGameActionListener());
        screen.highscores.addActionListener(new HighscoresActionListener());

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
    }

    public boolean userAuth()
    {
        String username = screen.getWelcome().getUsername();
        String password = screen.getWelcome().getPassword();

        //ServerConnection serverConnection = new ServerConnection();
        if (!username.equals("") && !password.equals("")) {

            currentUser = new User();
            currentUser.setPassword(password);
            currentUser.setUsername(username);

            String json = new Gson().toJson(currentUser);

            String message = serverConnection.stringMessageParser(serverConnection.post(json, "login/"));
            System.out.println(message);

            if (message.equals("Login successful"))
            {
                screen.getWelcome().getLblAccessDenied().setVisible(false);

                for (User user : api.getUsers() )
                {
                    if (user.getUsername().equals(screen.getWelcome().getUsername()))
                    {
                        currentUser = user;
                    }
                }
                return true;
            }
            else if (message.equals("Wrong username or password") || message.equals("Error in JSON")) {

                screen.getWelcome().getLblAccessDenied().setVisible(true);
            }
        }

        return false;
    }

    private class SignUpActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if (e.getSource() == screen.getSignUp().getBtnSignUp())
            {
                createUser();
            }
            if (e.getSource() == screen.getSignUp().getBtnBack())
            {
                screen.show(Screen.WELCOME);
                screen.getSignUp().clearFields();
            }

        }
    }

    public boolean createUser()
    {
        String firstName = screen.getSignUp().getFirstName();
        String lastName = screen.getSignUp().getLastName();
        String username = screen.getSignUp().getUsername();
        String password = screen.getSignUp().getPassword();
        String email = screen.getSignUp().getEmail();
        int type = 1;

            User user = new User();
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setUsername(username);
            user.setPassword(password);
            user.setEmail(email);
            user.setType(type);

            String json = new Gson().toJson(user);

            String message = serverConnection.stringMessageParser(serverConnection.post(json, "users/"));
            System.out.println(message);

            if (message.equals("User was created"))
            {
                screen.getSignUp().getSuccesfulCreate().setVisible(true);
                screen.getSignUp().getLblAlreadyExist().setVisible(false);
                return true;
            }
            else if(message.equals("Username or email already exists"))
            {
                screen.getSignUp().getLblAlreadyExist().setVisible(true);
                screen.getSignUp().getSuccesfulCreate().setVisible(false);
            }
            else if(message.equals("Error in JSON"))
            {
                System.out.println("Noget gik galt");
            }

        return false;
    }


    private class MenuActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource()== screen.getMenu().getBtnHighscores())
            {
                ArrayList<Score> scores = api.getHighscores();
                HighscoreTableModel tableModel = new HighscoreTableModel(scores);
                screen.show(Screen.HIGHSCORES);
                screen.getHighscores().getTable().setModel(tableModel);

                serverConnection.get("scores");
            }
            if (e.getSource() == screen.getMenu().getBtnNewGame())
            {
                screen.show(Screen.NEWGAME);
            }
            if (e.getSource() == screen.getMenu().getBtnLogOff())
            {
                screen.show(Screen.WELCOME);
                System.out.println("Logging off the system");
            }

        }
    }

    private class NewGameActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == screen.getNewGame().getBtnStartGame())
            {
                createGame();
            }
            if (e.getSource() == screen.getNewGame().getBtnBack())
            {
                screen.show(Screen.MENU);
                screen.getNewGame().getLblCreated().setVisible(false);
                screen.getNewGame().clearTextFields();
            }

        }
    }

    public String createGame()
    {
        if(!screen.getNewGame().getGameName().equals("") && !screen.getNewGame().getControls().equals(""))
        {
            Gamer host = new Gamer();
            host.setId(currentUser.getId());
            host.setControls(screen.getNewGame().getControls());

            //Gamer oppnonent = new Gamer();

            Game game = new Game();
            game.setName(screen.getNewGame().getGameName());
            game.setHost(host);
            //game.setOpponent(oppnonent);
            game.setMapSize(15);

        /*for (User user : api.getUsers() )
        {
            if (user.getUsername().equals(screen.getNewGame().getOpponnetUsername()))
            {
                oppnonent.setId(user.getId());
            }
        }*/

            screen.getNewGame().getLblCreated().setVisible(true);
            screen.getNewGame().clearTextFields();

            return api.createGame(game);
        }

        else
            return "";
    }

    private class HighscoresActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == screen.getHighscores().getBtnBack())
            {
                screen.show(Screen.MENU);
            }
        }
    }


    public class HighscoreTableModel extends AbstractTableModel
    {
        private static final long serialVersionUID = 1L;

        private ArrayList<Score> highscores;
        private String[] columns = {"Game ID", "Score", "Opponent ID"};
        private int numberOfRows;

        public HighscoreTableModel(ArrayList<Score> highscores)
        {
            this.highscores = highscores;
            fireTableStructureChanged();
        }

        @Override
        public int getColumnCount() {
            return columns.length;
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            return super.getColumnClass(columnIndex);
        }

        @Override
        public int getRowCount() {
            numberOfRows = highscores.size();
            return numberOfRows;
        }
        public String getColumnName(int columnIndex) {

            return columns[columnIndex];

        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            switch (columnIndex) {

                case 0:
                    return highscores.get(rowIndex).getGame().getGameId();
                case 1:
                    return highscores.get(rowIndex).getScore() ;
                case 2:
                    return highscores.get(rowIndex).getOpponent().getId();

            }

            return null;
        }

        public Score getSelectedScore(int row)
        {
            return highscores.get(row);
        }
    }



}

