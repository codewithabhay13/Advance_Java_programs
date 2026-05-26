import javax.swing.*;
import java.awt.event.*;

public class LoginGUI {

    public static void main(String[] args) {

        // Frame
        JFrame frame =
            new JFrame("AI Mock Interview");

        frame.setSize(400, 300);

        frame.setLayout(null);

        frame.setDefaultCloseOperation(
            JFrame.EXIT_ON_CLOSE);

        // Username Label
        JLabel userLabel =
            new JLabel("Username:");

        userLabel.setBounds(50, 50, 100, 30);

        frame.add(userLabel);

        // Username Field
        JTextField userText =
            new JTextField();

        userText.setBounds(150, 50, 150, 30);

        frame.add(userText);

        // Password Label
        JLabel passLabel =
            new JLabel("Password:");

        passLabel.setBounds(50, 100, 100, 30);

        frame.add(passLabel);

        // Password Field
        JPasswordField passText =
            new JPasswordField();

        passText.setBounds(150, 100, 150, 30);

        frame.add(passText);

        // Button
        JButton loginButton =
            new JButton("Login");

        loginButton.setBounds(130, 170, 100, 40);

        frame.add(loginButton);

        // Button Click Event
        loginButton.addActionListener(
            new ActionListener() {

                public void actionPerformed(
                    ActionEvent e) {

                    String username =
                        userText.getText();

                    String password =
                        new String(
                            passText.getPassword());

                    // Validation
                    if(username.equals("admin")
                            && password.equals("1234")) {

                        JOptionPane.showMessageDialog(
                            frame,
                            "Login Successful");

                    } else {

                        JOptionPane.showMessageDialog(
                            frame,
                            "Invalid Username or Password");
                    }
                }
            });

        // Show Frame
        frame.setVisible(true);
    }
}