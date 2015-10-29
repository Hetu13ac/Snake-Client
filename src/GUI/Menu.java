package GUI;

/**
 * Created by HenrikTuyen on 29/10/15.
 */
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class Menu extends JPanel {
    private JLabel lblUserMenu;
    private JButton btnNewgame;
    private JButton btnHighscores;
    private JButton btnDeleteGame;
    private JButton btnLogOff;

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

        btnNewgame = new JButton("Start New Game");
        btnNewgame.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        btnNewgame.setBounds(194, 119, 252, 40);
        add(btnNewgame);

        btnHighscores = new JButton("Highscores");
        btnHighscores.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        btnHighscores.setBounds(194, 171, 252, 40);
        add(btnHighscores);

        btnDeleteGame = new JButton("Delete Game");
        btnDeleteGame.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        btnDeleteGame.setBounds(194, 223, 252, 40);
        add(btnDeleteGame);

        btnLogOff = new JButton("Log Off");
        btnLogOff.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        btnLogOff.setBounds(194, 278, 252, 40);
        add(btnLogOff);

    }

}