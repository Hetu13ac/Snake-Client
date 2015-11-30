package GUI;

/**
 * Created by HenrikTuyen on 26/11/15.
 */
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class JoinGame extends JPanel {

    private JLabel lblJoinGame;
    private JButton btnBack;
    private JLabel lblGameName;
    private JTextField textFieldGameName;
    private JLabel instructions;
    private JLabel lblEnterActions;
    private JTextField textFieldControls;
    private JLabel lblInstructions;
    private JButton btnJoinGame;

    private String gameName;
    private String controls;

    /**
     * Create the panel.
     */
    public JoinGame() {

        setBounds(100, 100, 640, 410);
        setLayout(null);

        lblJoinGame = new JLabel("Join Game");
        lblJoinGame.setFont(new Font("Lucida Grande", Font.BOLD, 30));
        lblJoinGame.setBounds(237, 33, 165, 40);
        add(lblJoinGame);

        btnBack = new JButton("Back");
        btnBack.setBounds(6, 337, 117, 29);
        add(btnBack);

        lblGameName = new JLabel("Type game name to join:");
        lblGameName.setBounds(124, 85, 155, 16);
        add(lblGameName);

        textFieldGameName = new JTextField();
        textFieldGameName.setBounds(276, 79, 218, 28);
        add(textFieldGameName);
        textFieldGameName.setColumns(10);

        instructions = new JLabel("");
        instructions.setBounds(204, 136, 231, 133);
        Image img = new ImageIcon(this.getClass().getResource("/img/instructions2.png")).getImage();
        instructions.setIcon(new ImageIcon(img));
        add(instructions);

        lblEnterActions = new JLabel("Enter control actions:\n");
        lblEnterActions.setBounds(129, 275, 139, 16);
        add(lblEnterActions);

        textFieldControls = new JTextField();
        textFieldControls.setBounds(261, 269, 218, 28);
        add(textFieldControls);
        textFieldControls.setColumns(10);

        lblInstructions = new JLabel("Instructions");
        lblInstructions.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
        lblInstructions.setBounds(271, 119, 91, 16);
        add(lblInstructions);

        btnJoinGame = new JButton("Join game");
        btnJoinGame.setBounds(504, 337, 117, 29);
        add(btnJoinGame);

    }

    public JButton getBtnJoinGame()
    {
        return btnJoinGame;
    }


    public JButton getBtnBack()
    {
        return btnBack;
    }

    public String getGameName()
    {
        gameName = textFieldGameName.getText();
        return gameName;
    }

    public String getControls()
    {
        controls = textFieldControls.getText();
        return controls;
    }

    public void clearTextFields()
    {
        textFieldGameName.setText("");
        textFieldControls.setText("");
    }

    public void addActionListener(ActionListener l){
        btnBack.addActionListener(l);
        btnJoinGame.addActionListener(l);

    }

}