package GUI;

/**
 * Created by HenrikTuyen on 23/11/15.
 */
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;

public class NewGame extends JPanel {

    private JLabel lblNewGame;
    private JButton btnBack;
    private JLabel lblGameName;
    private JTextField textFieldGameName;
    private JLabel instructions;
    private JLabel lblEnterActions;
    private JTextField textFieldControls;
    private JLabel lblInstructions;
    private JButton btnStartGame;
    private JLabel lblCreated;

    private String gameName;
    private String controls;


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

        lblGameName = new JLabel("Create game name:");
        lblGameName.setBounds(138, 85, 120, 16);
        add(lblGameName);

        textFieldGameName = new JTextField();
        textFieldGameName.setBounds(261, 79, 218, 28);
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

        btnStartGame = new JButton("Start Game");
        btnStartGame.setBounds(504, 337, 117, 29);
        add(btnStartGame);

        lblCreated = new JLabel("Game was succesfully created. Click \"Back\" for menu");
        lblCreated.setForeground(Color.BLUE);
        lblCreated.setBounds(151, 303, 338, 16);
        add(lblCreated);
        lblCreated.setVisible(false);

    }

    public JButton getBtnStartGame()
    {
        return btnStartGame;
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

    public JLabel getLblCreated()
    {
        return lblCreated;
    }

    public void clearTextFields()
    {
        textFieldGameName.setText("");
        textFieldControls.setText("");
    }

    public void addActionListener(ActionListener l){
        btnBack.addActionListener(l);
        btnStartGame.addActionListener(l);

    }
}
