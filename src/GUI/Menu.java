package GUI;

/**
 * Created by HenrikTuyen on 29/10/15.
 */
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class Menu extends JPanel {
    private JLabel lblUserMenu;
    private JButton btnNewgame;
    private JButton btnHighscores;
    private JButton btnDeleteGame;
    private JButton btnLogOff;
    private JButton btnJoinGame;
    private JButton btnShowResult;

    /**
     * Create the panel.
     */
    public Menu() {

        setBounds(100, 100, 640, 410);
        setLayout(null);

        lblUserMenu = new JLabel("Menu");
        lblUserMenu.setFont(new Font("Lucida Grande", Font.BOLD, 30));
        lblUserMenu.setBounds(274, 49, 92, 40);
        add(lblUserMenu);

        btnNewgame = new JButton("Create New Game");
        btnNewgame.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        btnNewgame.setBounds(194, 90, 252, 40);
        add(btnNewgame);

        btnHighscores = new JButton("Highscores");
        btnHighscores.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        btnHighscores.setBounds(194, 170, 252, 40);
        add(btnHighscores);

        btnDeleteGame = new JButton("Delete Game");
        btnDeleteGame.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        btnDeleteGame.setBounds(194, 249, 252, 40);
        add(btnDeleteGame);

        btnLogOff = new JButton("Log Off");
        btnLogOff.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        btnLogOff.setBounds(194, 301, 252, 40);
        add(btnLogOff);

        btnJoinGame = new JButton("Join game");
        btnJoinGame.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        btnJoinGame.setBounds(194, 129, 252, 40);
        add(btnJoinGame);

        btnShowResult = new JButton("Show Result");
        btnShowResult.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        btnShowResult.setBounds(194, 210, 252, 40);
        add(btnShowResult);

    }



    public JButton getBtnHighscores()
    {
        return btnHighscores;
    }

    public JButton getBtnLogOff()
    {
        return btnLogOff;
    }

    public JButton getBtnNewGame()
    {
        return btnNewgame;
    }

    public JButton getBtnJoinGame()
    {
        return btnJoinGame;
    }

    public void addActionListener(ActionListener l)
    {
        btnHighscores.addActionListener(l);
        btnLogOff.addActionListener(l);
        btnNewgame.addActionListener(l);
        btnJoinGame.addActionListener(l);
    }

}