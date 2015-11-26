package GUI;

/**
 * Created by HenrikTuyen on 23/11/15.
 */
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class NewGame extends JPanel {
    private JLabel lblNewGame;
    private JButton btnBack;

    /**
     * Create the panel.
     */
    public NewGame()
    {
        setBounds(100, 100, 640, 410);
        setLayout(null);

        lblNewGame = new JLabel("Start New Game");
        lblNewGame.setFont(new Font("Lucida Grande", Font.BOLD, 30));
        lblNewGame.setBounds(196, 33, 247, 40);
        add(lblNewGame);

        btnBack = new JButton("Back");
        btnBack.setBounds(6, 337, 117, 29);
        add(btnBack);
    }

    public JButton getBtnBack()
    {
        return btnBack;
    }

    public void addActionListener(ActionListener l){
        btnBack.addActionListener(l);
    }
}
