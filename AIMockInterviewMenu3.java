import java.util.Scanner;
import java.util.Random;
import java.io.*;

public class AIMockInterviewMenu3 {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        // ================= REGISTER =================

        System.out.println("===== REGISTER =====");

        System.out.print("Create Username: ");
        String savedUsername = sc.nextLine();

        System.out.print("Create Password: ");
        String savedPassword = sc.nextLine();

        System.out.println("\nRegistration Successful!");

        // ================= LOGIN =================

        System.out.println("\n===== LOGIN =====");

        System.out.print("Enter Username: ");
        String username = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        if(!(username.equals(savedUsername)
                && password.equals(savedPassword))) {

            System.out.println("\nInvalid Login");
            sc.close();
            return;
        }

        System.out.println("\nLogin Successful!");

        int choice;

        do {

            // ================= MENU =================

            System.out.println("\n===== MAIN MENU =====");

            System.out.println("1. Start Interview");
            System.out.println("2. View Result File");
            System.out.println("3. Exit");

            System.out.print("Enter Choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch(choice) {

                // ================= START INTERVIEW =================

                case 1:

                    System.out.println(
                        "\n===== SELECT INTERVIEW TYPE =====");

                    System.out.println("1. HR Round");
                    System.out.println("2. Technical Round");

                    System.out.print("Enter Choice: ");

                    int roundChoice = sc.nextInt();
                    sc.nextLine();

                    String questions[];
                    String keywords[];

                    // ================= HR ROUND =================

                    if(roundChoice == 1) {

                        questions = new String[] {

                            "Tell me about yourself",
                            "Why should we hire you?",
                            "What are your strengths?",
                            "Where do you see yourself in 5 years?"
                        };

                        keywords = new String[] {

                            "student",
                            "skills",
                            "hardworking",
                            "growth"
                        };
                    }

                    // ================= TECHNICAL ROUND =================

                    else {

                        questions = new String[] {

                            "What is Java?",
                            "What is OOP?",
                            "What is Inheritance?",
                            "What is Polymorphism?"
                        };

                        keywords = new String[] {

                            "programming",
                            "object",
                            "class",
                            "many"
                        };
                    }

                    boolean used[] =
                        new boolean[questions.length];

                    int score = 0;
                    int totalQuestions = 3;

                    // ================= QUESTIONS =================

                    for(int i = 0; i < totalQuestions; i++) {

                        int index;

                        do {

                            index =
                                rand.nextInt(questions.length);

                        } while(used[index]);

                        used[index] = true;

                        System.out.println(
                            "\nQ" + (i + 1) +
                            ". " + questions[index]);

                        // ================= TIMER =================

                        System.out.println(
                            "Think for 5 seconds...");

                        for(int t = 5; t >= 1; t--) {

                            System.out.println(t);
                            Thread.sleep(1000);
                        }

                        // ================= ANSWER =================

                        System.out.print("Your Answer: ");

                        String answer = sc.nextLine();

                        if(answer.toLowerCase()
                                .contains(keywords[index])) {

                            System.out.println(
                                "Good Answer");

                            score += 5;

                        } else {

                            System.out.println(
                                "Needs Improvement");
                        }
                    }

                    // ================= RESULT =================

                    double percentage =
                        (score / (totalQuestions * 5.0)) * 100;

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

                    System.out.println(
                        "\n===== FINAL RESULT =====");

                    System.out.println(
                        "Username: " + username);

                    System.out.println(
                        "Score: " + score);

                    System.out.println(
                        "Percentage: " + percentage + "%");

                    System.out.println(
                        "Grade: " + grade);

                    // ================= SAVE RESULT =================

                    FileWriter fw =
                        new FileWriter("result.txt");

                    fw.write(
                        "===== AI MOCK INTERVIEW RESULT =====\n");

                    fw.write(
                        "Username: " + username + "\n");

                    fw.write(
                        "Score: " + score + "\n");

                    fw.write(
                        "Percentage: " + percentage + "%\n");

                    fw.write(
                        "Grade: " + grade);

                    fw.close();

                    System.out.println(
                        "\nResult Saved Successfully!");

                    break;

                // ================= VIEW RESULT =================

                case 2:

                    File file = new File("result.txt");

                    if(file.exists()) {

                        BufferedReader br =
                            new BufferedReader(
                                new FileReader(file));

                        String line;

                        System.out.println(
                            "\n===== SAVED RESULT =====");

                        while((line = br.readLine()) != null) {

                            System.out.println(line);
                        }

                        br.close();

                    } else {

                        System.out.println(
                            "\nNo Result Found");
                    }

                    break;

                // ================= EXIT =================

                case 3:

                    System.out.println(
                        "\nExiting Program...");
                    break;

                // ================= INVALID =================

                default:

                    System.out.println(
                        "\nInvalid Choice");
            }

        } while(choice != 3);

        sc.close();
    }
}