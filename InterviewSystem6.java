import java.util.Random;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class InterviewSystem6 {

    public static void main(String[] args) throws InterruptedException {

        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

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

        System.out.println("===== AI MOCK INTERVIEW =====");

        System.out.print("Enter Your Name: ");
        String name = sc.nextLine();

        for(int i = 0; i < totalQuestions; i++) {

            int index;

            do {
                index = rand.nextInt(questions.length);
            } while(used[index]);

            used[index] = true;

            System.out.println("\nQ" + (i + 1) + ". " + questions[index]);

            // Countdown Timer
            System.out.println("You have 5 seconds to think...");

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

        System.out.println("Name: " + name);
        System.out.println("Score: " + score);
        System.out.println("Percentage: " + percentage + "%");
        System.out.println("Grade: " + grade);

        // Save Result
        try {

            FileWriter fw = new FileWriter("result.txt");

            fw.write("===== AI MOCK INTERVIEW RESULT =====\n");
            fw.write("Name: " + name + "\n");
            fw.write("Score: " + score + "\n");
            fw.write("Percentage: " + percentage + "%\n");
            fw.write("Grade: " + grade);

            fw.close();

            System.out.println("\nResult Saved in result.txt");

        } catch(IOException e) {

            System.out.println("File Error");
        }

        sc.close();
    }
}