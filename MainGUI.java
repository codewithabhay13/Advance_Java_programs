import javax.swing.*;
import java.awt.event.*;
import java.io.FileWriter;

public class MainGUI {

    static int index = 0;
    static int score = 0;

    // Dynamic Arrays
    static String questions[];
    static String keywords[];

    public static void main(String[] args) {

        // ================= LOGIN FRAME =================

        JFrame loginFrame =
            new JFrame("AI Mock Interview");

        loginFrame.setSize(400, 300);

        loginFrame.setLayout(null);

        loginFrame.setDefaultCloseOperation(
            JFrame.EXIT_ON_CLOSE);

        // Username Label
        JLabel userLabel =
            new JLabel("Username:");

        userLabel.setBounds(50, 50, 100, 30);

        loginFrame.add(userLabel);

        // Username Field
        JTextField userField =
            new JTextField();

        userField.setBounds(150, 50, 150, 30);

        loginFrame.add(userField);

        // Password Label
        JLabel passLabel =
            new JLabel("Password:");

        passLabel.setBounds(50, 100, 100, 30);

        loginFrame.add(passLabel);

        // Password Field
        JPasswordField passField =
            new JPasswordField();

        passField.setBounds(150, 100, 150, 30);

        loginFrame.add(passField);

        // Login Button
        JButton loginButton =
            new JButton("Login");

        loginButton.setBounds(130, 170, 100, 40);

        loginFrame.add(loginButton);

        // ================= LOGIN BUTTON EVENT =================

        loginButton.addActionListener(
            new ActionListener() {

                public void actionPerformed(
                    ActionEvent e) {

                    String username =
                        userField.getText();

                    String password =
                        new String(
                            passField.getPassword());

                    // Login Check
                    if(username.equals("admin")
                            && password.equals("1234")) {

                        JOptionPane.showMessageDialog(
                            loginFrame,
                            "Login Successful");

                        // Close Login Window
                        loginFrame.dispose();

                        // Open Selection Window
                        openSelectionWindow();

                    } else {

                        JOptionPane.showMessageDialog(
                            loginFrame,
                            "Invalid Username or Password");
                    }
                }
            });

        loginFrame.setVisible(true);
    }

    // ================= SELECTION WINDOW =================

    public static void openSelectionWindow() {

        JFrame selectFrame =
            new JFrame("Select Interview Type");

        selectFrame.setSize(400, 300);

        selectFrame.setLayout(null);

        selectFrame.setDefaultCloseOperation(
            JFrame.EXIT_ON_CLOSE);

        JLabel title =
            new JLabel("Choose Interview Round");

        title.setBounds(100, 40, 200, 30);

        selectFrame.add(title);

        // HR Button
        JButton hrButton =
            new JButton("HR Round");

        hrButton.setBounds(120, 90, 150, 40);

        selectFrame.add(hrButton);

        // Technical Button
        JButton techButton =
            new JButton("Technical Round");

        techButton.setBounds(120, 150, 150, 40);

        selectFrame.add(techButton);

        // ================= HR BUTTON EVENT =================

        hrButton.addActionListener(
            new ActionListener() {

                public void actionPerformed(
                    ActionEvent e) {

                    // HR Questions
                    questions = new String[] {

                        "Tell me about yourself",
                        "Why should we hire you?",
                        "What are your strengths?"
                    };

                    keywords = new String[] {

                        "student",
                        "skills",
                        "hardworking"
                    };

                    index = 0;
                    score = 0;

                    selectFrame.dispose();

                    openInterviewWindow();
                }
            });

        // ================= TECH BUTTON EVENT =================

        techButton.addActionListener(
            new ActionListener() {

                public void actionPerformed(
                    ActionEvent e) {

                    // Technical Questions
                    questions = new String[] {

                        "What is Java?",
                        "What is OOP?",
                        "What is Inheritance?"
                    };

                    keywords = new String[] {

                        "programming",
                        "object",
                        "class"
                    };

                    index = 0;
                    score = 0;

                    selectFrame.dispose();

                    openInterviewWindow();
                }
            });

        selectFrame.setVisible(true);
    }

    // ================= INTERVIEW WINDOW =================

    public static void openInterviewWindow() {

        JFrame frame =
            new JFrame("AI Mock Interview");

        frame.setSize(500, 400);

        frame.setLayout(null);

        frame.setDefaultCloseOperation(
            JFrame.EXIT_ON_CLOSE);

        // ================= PROGRESS BAR =================

        JProgressBar progressBar =
            new JProgressBar(0, questions.length);

        progressBar.setValue(0);

        progressBar.setStringPainted(true);

        progressBar.setString("Interview Progress");

        progressBar.setBounds(50, 20, 400, 25);

        frame.add(progressBar);

        // ================= QUESTION LABEL =================

        JLabel questionLabel =
            new JLabel(questions[index]);

        questionLabel.setBounds(50, 70, 300, 30);

        frame.add(questionLabel);

        // ================= TIMER LABEL =================

        JLabel timerLabel =
            new JLabel("Time Left: 10");

        timerLabel.setBounds(350, 70, 120, 30);

        frame.add(timerLabel);

        // ================= ANSWER FIELD =================

        JTextField answerField =
            new JTextField();

        answerField.setBounds(50, 130, 300, 30);

        frame.add(answerField);

        // ================= TIMER VARIABLES =================

        final int[] timeLeft = {10};

        Timer timer =
            new Timer(1000, null);

        // ================= NEXT BUTTON =================

        JButton nextButton =
            new JButton("Next");

        nextButton.setBounds(180, 220, 100, 40);

        frame.add(nextButton);

        // ================= TIMER LOGIC =================

        timer.addActionListener(
            new ActionListener() {

                public void actionPerformed(
                    ActionEvent e) {

                    timeLeft[0]--;

                    timerLabel.setText(
                        "Time Left: " + timeLeft[0]);

                    // Auto Next
                    if(timeLeft[0] <= 0) {

                        timer.stop();

                        JOptionPane.showMessageDialog(
                            frame,
                            "Time Up!");

                        nextButton.doClick();
                    }
                }
            });

        // Start Timer
        timer.start();

        // ================= NEXT BUTTON EVENT =================

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

                    // ================= UPDATE PROGRESS =================

                    progressBar.setValue(index);

                    // ================= NEXT QUESTION =================

                    if(index < questions.length) {

                        questionLabel.setText(
                            questions[index]);

                        answerField.setText("");

                        // Reset Timer
                        timeLeft[0] = 10;

                        timerLabel.setText(
                            "Time Left: 10");

                        timer.restart();

                    }

                    // ================= FINAL RESULT =================

                    else {

                        timer.stop();

                        // Close Interview Window
                        frame.dispose();

                        // Percentage
                        double percentage =
                            (score /
                            (questions.length * 5.0)) * 100;

                        String grade;

                        if(percentage >= 80) {

                            grade = "A";

                        }
                        else if(percentage >= 60) {

                            grade = "B";

                        }
                        else {

                            grade = "C";
                        }

                        // ================= SAVE RESULT =================

                        try {

                            FileWriter fw =
                                new FileWriter(
                                    "result.txt");

                            fw.write(
                                "===== AI MOCK INTERVIEW RESULT =====\n");

                            fw.write(
                                "Score: " + score + "\n");

                            fw.write(
                                "Percentage: "
                                + percentage + "%\n");

                            fw.write(
                                "Grade: " + grade);

                            fw.close();

                        } catch(Exception ex) {

                            System.out.println(
                                "File Error");
                        }

                        // ================= RESULT WINDOW =================

                        JFrame resultFrame =
                            new JFrame("Final Result");

                        resultFrame.setSize(400, 300);

                        resultFrame.setLayout(null);

                        resultFrame.setDefaultCloseOperation(
                            JFrame.EXIT_ON_CLOSE);

                        JLabel resultLabel =
                            new JLabel(
                                "Interview Finished");

                        resultLabel.setBounds(
                            120, 30, 200, 30);

                        resultFrame.add(resultLabel);

                        JLabel scoreLabel =
                            new JLabel(
                                "Score: " + score);

                        scoreLabel.setBounds(
                            120, 80, 200, 30);

                        resultFrame.add(scoreLabel);

                        JLabel percentLabel =
                            new JLabel(
                                "Percentage: "
                                + percentage + "%");

                        percentLabel.setBounds(
                            120, 120, 200, 30);

                        resultFrame.add(percentLabel);

                        JLabel gradeLabel =
                            new JLabel(
                                "Grade: " + grade);

                        gradeLabel.setBounds(
                            120, 160, 200, 30);

                        resultFrame.add(gradeLabel);

                        JButton exitButton =
                            new JButton("Exit");

                        exitButton.setBounds(
                            140, 210, 100, 40);

                        resultFrame.add(exitButton);

                        // Exit Button Event
                        exitButton.addActionListener(
                            new ActionListener() {

                                public void actionPerformed(
                                    ActionEvent e) {

                                    System.exit(0);
                                }
                            });

                        resultFrame.setVisible(true);
                    }
                }
            });

        frame.setVisible(true);
    }
}