import java.util.Scanner;
import java.util.Random;
import java.io.FileWriter;
import java.io.IOException;

public class AIMockInterview {

    public static void main(String[] args) throws InterruptedException {

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

        if(username.equals(savedUsername) &&
           password.equals(savedPassword)) {

            System.out.println("\nLogin Successful!");
            System.out.println("\n===== STARTING INTERVIEW =====");

        } else {

            System.out.println("\nInvalid Login");
            sc.close();
            return;
        }

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

            // Timer
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

        // ================= RESULT =================

        double percentage = (score / (totalQuestions * 5.0)) * 100;

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

        System.out.println("\n===== FINAL RESULT =====");

        System.out.println("Username: " + username);
        System.out.println("Score: " + score);
        System.out.println("Percentage: " + percentage + "%");
        System.out.println("Grade: " + grade);

        // ================= FILE SAVE =================

        try {

            FileWriter fw = new FileWriter("result.txt");

            fw.write("===== AI MOCK INTERVIEW RESULT =====\n");
            fw.write("Username: " + username + "\n");
            fw.write("Score: " + score + "\n");
            fw.write("Percentage: " + percentage + "%\n");
            fw.write("Grade: " + grade);

            fw.close();

            System.out.println("\nResult Saved Successfully!");

        } catch(IOException e) {

            System.out.println("File Error");
        }

        sc.close();
    }
}