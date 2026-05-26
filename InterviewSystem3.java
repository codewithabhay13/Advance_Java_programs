import java.util.Random;
import java.util.Scanner;

public class InterviewSystem3 {

    public static void main(String[] args) {

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

        int score = 0;

        System.out.println("=== AI Mock Interview ===");

        for(int i = 0; i < 3; i++) {

            int index = rand.nextInt(questions.length);

            System.out.println("\nQ" + (i + 1) + ". " + questions[index]);

            String answer = sc.nextLine();

            if(answer.toLowerCase().contains(keywords[index])) {

                System.out.println("Good Answer");
                score += 5;

            } else {

                System.out.println("Needs Improvement");
            }
        }

        double percentage = (score / 15.0) * 100;

        System.out.println("\nFinal Score: " + score + "/15");
        System.out.println("Percentage: " + percentage + "%");

        // Grade System
        if(percentage >= 80) {
            System.out.println("Grade: A");
        }
        else if(percentage >= 60) {
            System.out.println("Grade: B");
        }
        else {
            System.out.println("Grade: C");
        }

        sc.close();
    }
}