import javax.swing.*;
import java.awt.event.*;

public class InterviewGUI {

    static int index = 0;
    static int score = 0;

    static String questions[] = {

        "What is Java?",
        "What is OOP?",
        "What is Inheritance?"
    };

    static String keywords[] = {

        "programming",
        "object",
        "class"
    };

    public static void main(String[] args) {

        JFrame frame =
            new JFrame("AI Mock Interview");

        frame.setSize(500, 300);

        frame.setLayout(null);

        frame.setDefaultCloseOperation(
            JFrame.EXIT_ON_CLOSE);

        // Question Label
        JLabel questionLabel =
            new JLabel(questions[index]);

        questionLabel.setBounds(50, 50, 400, 30);

        frame.add(questionLabel);

        // Answer Field
        JTextField answerField =
            new JTextField();

        answerField.setBounds(50, 100, 300, 30);

        frame.add(answerField);

        // Next Button
        JButton nextButton =
            new JButton("Next");

        nextButton.setBounds(180, 170, 100, 40);

        frame.add(nextButton);

        // Button Event
        nextButton.addActionListener(
            new ActionListener() {

                public void actionPerformed(
                    ActionEvent e) {

                    String answer =
                        answerField.getText();

                    // Check Answer
                    if(answer.toLowerCase()
                            .contains(keywords[index])) {

                        score += 5;
                    }

                    index++;

                    // Next Question
                    if(index < questions.length) {

                        questionLabel.setText(
                            questions[index]);

                        answerField.setText("");

                    } else {

                        JOptionPane.showMessageDialog(
                            frame,
                            "Interview Finished\nScore: "
                            + score);

                        System.exit(0);
                    }
                }
            });

        frame.setVisible(true);
    }
}