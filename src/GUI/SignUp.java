package GUI;

/**
 * Created by HenrikTuyen on 10/11/15.
 */
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class SignUp extends JPanel
{
    private JLabel lblSignUp;
    private JLabel lblPleaseFillIn;
    private JLabel lblFirstName;
    private JLabel lblLastName;
    private JLabel lblUsername;
    private JLabel lblPassword;
    private JLabel lblEmail;
    private JTextField textFieldFirstName;
    private JTextField textFieldLastName;
    private JTextField textFieldUsername;
    private JTextField textFieldPassword;
    private JTextField textFieldEmail;
    private JButton btnSignUp;
    private JButton btnBack;

    /**
     * Create the panel.
     */
    public SignUp()
    {
        setBounds(100, 100, 640, 410);
        setLayout(null);

        lblSignUp = new JLabel("Sign up for SNAKE!");
        lblSignUp.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
        lblSignUp.setBounds(179, 55, 281, 33);
        add(lblSignUp);

        lblPleaseFillIn = new JLabel("Please fill in your details below:");
        lblPleaseFillIn.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        lblPleaseFillIn.setBounds(162, 100, 311, 25);
        add(lblPleaseFillIn);

        lblFirstName = new JLabel("First name:");
        lblFirstName.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        lblFirstName.setBounds(162, 141, 104, 16);
        add(lblFirstName);

        lblLastName = new JLabel("Last name:");
        lblLastName.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        lblLastName.setBounds(162, 174, 96, 16);
        add(lblLastName);

        lblUsername = new JLabel("Username:");
        lblUsername.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        lblUsername.setBounds(162, 205, 96, 16);
        add(lblUsername);

        lblPassword = new JLabel("Password:");
        lblPassword.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        lblPassword.setBounds(162, 239, 96, 16);
        add(lblPassword);

        lblEmail = new JLabel("Email:");
        lblEmail.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        lblEmail.setBounds(162, 270, 69, 16);
        add(lblEmail);

        textFieldFirstName = new JTextField();
        textFieldFirstName.setColumns(10);
        textFieldFirstName.setBounds(262, 137, 271, 25);
        add(textFieldFirstName);

        textFieldLastName = new JTextField();
        textFieldLastName.setColumns(10);
        textFieldLastName.setBounds(262, 171, 271, 25);
        add(textFieldLastName);

        textFieldUsername = new JTextField();
        textFieldUsername.setColumns(10);
        textFieldUsername.setBounds(262, 202, 271, 25);
        add(textFieldUsername);

        textFieldPassword = new JTextField();
        textFieldPassword.setColumns(10);
        textFieldPassword.setBounds(262, 236, 271, 25);
        add(textFieldPassword);

        textFieldEmail = new JTextField();
        textFieldEmail.setColumns(10);
        textFieldEmail.setBounds(262, 267, 271, 25);
        add(textFieldEmail);

        btnSignUp = new JButton("Sign Up");
        btnSignUp.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        btnSignUp.setBounds(261, 304, 117, 33);
        add(btnSignUp);

        btnBack = new JButton("Back");
        btnBack.setBounds(6, 375, 117, 29);
        add(btnBack);
    }

}
