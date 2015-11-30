package GUI;

/**
 * Created by HenrikTuyen on 29/10/15.
 */

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Screen extends JFrame
{

    private JPanel contentPane;
    private CardLayout c;

    public static final String WELCOME = "welcome1234";
    public static final String SIGNUP = "signup123";
    public static final String MENU = "menu123";
    public static final String HIGHSCORES = "highscore123";
    public static final String NEWGAME = "newgame123";
    public static final String JOINGAME = "joingame123";

    public Welcome welcome;
    public Menu menu;
    public SignUp signUp;
    public Highscores highscores;
    public NewGame newGame;
    public JoinGame joinGame;


    public Screen() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 640, 410);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new CardLayout(0, 0));

        welcome = new Welcome();
        contentPane.add(welcome, WELCOME);

        signUp = new SignUp();
        contentPane.add(signUp, SIGNUP);

        menu = new Menu();
        contentPane.add(menu, MENU);

        newGame = new NewGame();
        contentPane.add(newGame, NEWGAME);

        joinGame = new JoinGame();
        contentPane.add(joinGame, JOINGAME);

        highscores = new Highscores();
        contentPane.add(highscores, HIGHSCORES);

        c = (CardLayout) getContentPane().getLayout();
    }

    public void show(String card)
    {
        c.show(this.getContentPane(), card);
    }

    public Welcome getWelcome()
    {
        return welcome;
    }

    public Menu getMenu()
    {
        return menu;
    }

    public SignUp getSignUp(){
        return signUp;
    }

    public Highscores getHighscores()
    {
        return highscores;
    }

    public NewGame getNewGame()
    {
        return newGame;
    }

    public JoinGame getJoinGame()
    {
        return joinGame;
    }

}