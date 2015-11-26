package GUI;

/**
 * Created by HenrikTuyen on 18/11/15.
 */

import SDK.Score;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

public class Highscores extends JPanel {

    private JLabel lblHighscore;
    private JScrollPane scrollPane;
    private JTable table;
    private JButton btnBack;

    /**
     * Create the panel.
     */
    public Highscores()
    {
        setBounds(100, 100, 640, 410);
        setLayout(null);

        lblHighscore = new JLabel("Highscore");
        lblHighscore.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
        lblHighscore.setBounds(243, 34, 154, 33);
        add(lblHighscore);

        table = new JTable();
        scrollPane = new JScrollPane(table);
        scrollPane.setBounds(77, 84, 482, 226);
        add(scrollPane);


        btnBack = new JButton("Back");
        btnBack.setBounds(21, 342, 117, 29);
        add(btnBack);

    }

    public JButton getBtnBack()
    {
        return btnBack;
    }

    public JTable getTable()
    {
        return table;
    }


    public void addActionListener(ActionListener l)
    {
        btnBack.addActionListener(l);
    }
}
