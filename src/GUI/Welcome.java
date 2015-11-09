package GUI;

/**
 * Created by HenrikTuyen on 29/10/15.
 */

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class Welcome extends JPanel {

    private JLabel lblWelcome;
    private JLabel lblUsername;
    private JLabel lblPassword;
    private JTextField textFieldUsername;
    private JPasswordField passwordField;
    private JButton btnLogin;

    private String username;
    private String password;
    private JLabel lblNoUser;
    private JButton btnSignUp;

    /**
     * Create the panel.
     */

    public Welcome() {

        setBounds(100, 100, 640, 410);
        setLayout(null);

        lblWelcome = new JLabel("Welcome to SNAKE");
        lblWelcome.setFont(new Font("Lucida Grande", Font.BOLD, 30));
        lblWelcome.setBounds(170, 49, 300, 58);
        add(lblWelcome);

        lblUsername = new JLabel("Username:");
        lblUsername.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        lblUsername.setBounds(136, 146, 107, 25);
        add(lblUsername);

        lblPassword = new JLabel("Password:");
        lblPassword.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        lblPassword.setBounds(142, 196, 101, 25);
        add(lblPassword);

        textFieldUsername = new JTextField();
        textFieldUsername.setBounds(244, 147, 246, 28);
        add(textFieldUsername);
        textFieldUsername.setColumns(10);

        passwordField = new JPasswordField();
        passwordField.setToolTipText("");
        passwordField.setBounds(244, 197, 246, 28);
        add(passwordField);

        btnLogin = new JButton("Login");
        btnLogin.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        btnLogin.setBounds(261, 237, 117, 33);
        add(btnLogin);

        lblNoUser = new JLabel("Don't have a user, please click here:");
        lblNoUser.setBounds(146, 301, 232, 16);
        add(lblNoUser);

        btnSignUp = new JButton("Sign Up");
        btnSignUp.setBounds(373, 296, 117, 29);
        add(btnSignUp);
    }

    public JButton getBtnLogin()
    {
        return btnLogin;
    }

    public String getUsername(){
        username = textFieldUsername.getText();
        return username;
    }

    public String getPassword(){
        password = passwordField.getText();
        return password;
    }

    public void addActionListener(ActionListener l){
        btnLogin.addActionListener(l);
        btnSignUp.addActionListener(l);
    }
}