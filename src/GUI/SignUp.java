package GUI;

/**
 * Created by HenrikTuyen on 10/11/15.
 */
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.*;
import java.awt.event.ActionListener;
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
    private JLabel lblAlreadyExist;
    private JTextField textFieldFirstName;
    private JTextField textFieldLastName;
    private JTextField textFieldUsername;
    private JTextField textFieldPassword;
    private JTextField textFieldEmail;
    private JButton btnSignUp;
    private JButton btnBack;
    private JLabel lblSuccesfulCreate;

    public String firstName;
    public String lastName;
    public String username;
    public String password;
    public String email;

    /**
     * Create the panel.
     */
    public SignUp()
    {
        setBounds(100, 100, 640, 410);
        setLayout(null);

        lblSignUp = new JLabel("Sign up for SNAKE!");
        lblSignUp.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
        lblSignUp.setBounds(179, 34, 281, 33);
        add(lblSignUp);

        lblPleaseFillIn = new JLabel("Please fill in your details below:");
        lblPleaseFillIn.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        lblPleaseFillIn.setBounds(162, 79, 311, 25);
        add(lblPleaseFillIn);

        lblFirstName = new JLabel("First name:");
        lblFirstName.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        lblFirstName.setBounds(162, 120, 104, 16);
        add(lblFirstName);

        lblLastName = new JLabel("Last name:");
        lblLastName.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        lblLastName.setBounds(162, 153, 96, 16);
        add(lblLastName);

        lblUsername = new JLabel("Username:");
        lblUsername.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        lblUsername.setBounds(162, 184, 96, 16);
        add(lblUsername);

        lblPassword = new JLabel("Password:");
        lblPassword.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        lblPassword.setBounds(162, 218, 96, 16);
        add(lblPassword);

        lblEmail = new JLabel("Email:");
        lblEmail.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
        lblEmail.setBounds(162, 249, 69, 16);
        add(lblEmail);

        textFieldFirstName = new JTextField();
        textFieldFirstName.setColumns(10);
        textFieldFirstName.setBounds(262, 116, 271, 25);
        add(textFieldFirstName);

        textFieldLastName = new JTextField();
        textFieldLastName.setColumns(10);
        textFieldLastName.setBounds(262, 150, 271, 25);
        add(textFieldLastName);

        textFieldUsername = new JTextField();
        textFieldUsername.setColumns(10);
        textFieldUsername.setBounds(262, 181, 271, 25);
        add(textFieldUsername);

        textFieldPassword = new JTextField();
        textFieldPassword.setColumns(10);
        textFieldPassword.setBounds(262, 215, 271, 25);
        add(textFieldPassword);

        textFieldEmail = new JTextField();
        textFieldEmail.setColumns(10);
        textFieldEmail.setBounds(262, 246, 271, 25);
        add(textFieldEmail);

        btnSignUp = new JButton("Sign Up");
        btnSignUp.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
        btnSignUp.setBounds(261, 283, 117, 33);
        add(btnSignUp);

        btnBack = new JButton("Back");
        btnBack.setBounds(6, 341, 117, 29);
        add(btnBack);

        lblSuccesfulCreate = new JLabel("User was succesfully created, click \"back\" to login");
        lblSuccesfulCreate.setForeground(Color.BLUE);
        lblSuccesfulCreate.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
        lblSuccesfulCreate.setBounds(162, 319, 374, 33);
        lblSuccesfulCreate.setVisible(false);
        add(lblSuccesfulCreate);

        lblAlreadyExist = new JLabel("Username or Email already exist, please try again");
        lblAlreadyExist.setForeground(Color.RED);
        lblAlreadyExist.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
        lblAlreadyExist.setBounds(162, 319, 359, 25);
        lblAlreadyExist.setVisible(false);
        add(lblAlreadyExist);
    }

    public String getFirstName()
    {
        firstName = textFieldFirstName.getText();
        return firstName;
    }

    public String getLastName()
    {
        lastName = textFieldLastName.getText();
        return lastName;
    }

    public String getUsername()
    {
        username = textFieldUsername.getText();
        return username;
    }

    public String getPassword()
    {
        password = textFieldPassword.getText();
        return password;
    }

    public String getEmail()
    {
        email = textFieldEmail.getText();
        return email;
    }

    public JButton getBtnSignUp()
    {
        return btnSignUp;
    }

    public JLabel getSuccesfulCreate()
    {
        return lblSuccesfulCreate;
    }

    public JLabel getLblAlreadyExist()
    {
        return lblAlreadyExist;
    }

    public JButton getBtnBack()
    {
        return btnBack;
    }

    public void clearFields()
    {
        textFieldFirstName.setText("");
        textFieldLastName.setText("");
        textFieldUsername.setText("");
        textFieldPassword.setText("");
        textFieldEmail.setText("");

        lblSuccesfulCreate.setVisible(false);
    }

    public void addActionListener(ActionListener l){
        btnSignUp.addActionListener(l);
        btnBack.addActionListener(l);
    }
}
