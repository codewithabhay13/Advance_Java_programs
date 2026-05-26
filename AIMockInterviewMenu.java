import java.util.Scanner;
import java.util.Random;
import java.io.*;

public class AIMockInterviewMenu {

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

        if(!(username.equals(savedUsername) &&
             password.equals(savedPassword))) {

            System.out.println("Invalid Login");
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

                case 1:

                    // ================= INTERVIEW =================

                    String questions[] = {
                        "What is Java?",
                        "What is OOP?",
                        "What is Inheritance?",
                        "What is Polymorphism?",
                        "What is Encapsulation?"
                    };

                    String keywords[] = {
                        "programming",
                        "object",
                        "class",
                        "many",
                        "binding"
                    };

                    boolean used[] = new boolean[questions.length];

                    int score = 0;
                    int totalQuestions = 3;

                    for(int i = 0; i < totalQuestions; i++) {

                        int index;

                        do {
                            index = rand.nextInt(questions.length);
                        } while(used[index]);

                        used[index] = true;

                        System.out.println("\nQ" + (i + 1) + ". " + questions[index]);

                        System.out.println("Think for 5 seconds...");

                        for(int t = 5; t >= 1; t--) {

                            System.out.println(t);
                            Thread.sleep(1000);
                        }

                        System.out.print("Your Answer: ");
                        String answer = sc.nextLine();

                        if(answer.toLowerCase().contains(keywords[index])) {

                            System.out.println("Good Answer");
                            score += 5;

                        } else {

                            System.out.println("Needs Improvement");
                        }
                    }

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

                    System.out.println("\n===== RESULT =====");

                    System.out.println("Score: " + score);
                    System.out.println("Percentage: " + percentage + "%");
                    System.out.println("Grade: " + grade);

                    // Save Result

                    FileWriter fw =
                        new FileWriter("result.txt");

                    fw.write("===== RESULT =====\n");
                    fw.write("Username: " + username + "\n");
                    fw.write("Score: " + score + "\n");
                    fw.write("Percentage: " + percentage + "%\n");
                    fw.write("Grade: " + grade);

                    fw.close();

                    System.out.println("Result Saved!");

                    break;

                case 2:

                    // ================= VIEW RESULT =================

                    File file = new File("result.txt");

                    if(file.exists()) {

                        BufferedReader br =
                            new BufferedReader(
                                new FileReader(file));

                        String line;

                        System.out.println("\n===== SAVED RESULT =====");

                        while((line = br.readLine()) != null) {

                            System.out.println(line);
                        }

                        br.close();

                    } else {

                        System.out.println("No Result Found");
                    }

                    break;

                case 3:

                    System.out.println("Exiting Program...");
                    break;

                default:

                    System.out.println("Invalid Choice");
            }

        } while(choice != 3);

        sc.close();
    }
}