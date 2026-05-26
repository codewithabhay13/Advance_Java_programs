import java.util.Random;
import java.util.Scanner;

public class InterviewSystem4 {

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

        // Track used questions
        boolean used[] = new boolean[questions.length];

        int score = 0;
        int totalQuestions = 3;

        System.out.println("===== AI Mock Interview =====");

        for(int i = 0; i < totalQuestions; i++) {

            int index;

            // Generate unique random question
            do {
                index = rand.nextInt(questions.length);
            } while(used[index]);

            used[index] = true;

            System.out.println("\nQ" + (i + 1) + ". " + questions[index]);

            System.out.print("Your Answer: ");
            String answer = sc.nextLine();

            // Answer checking
            if(answer.toLowerCase().contains(keywords[index])) {

                System.out.println("Correct / Good Answer");
                score += 5;

            } else {

                System.out.println("Needs Improvement");
            }
        }

        // Result
        double percentage = (score / (totalQuestions * 5.0)) * 100;

        System.out.println("\n===== FINAL RESULT =====");
        System.out.println("Score: " + score + "/" + (totalQuestions * 5));
        System.out.println("Percentage: " + percentage + "%");

        // Grade
        if(percentage >= 80) {

            System.out.println("Grade: A");

        } else if(percentage >= 60) {

            System.out.println("Grade: B");

        } else {

            System.out.println("Grade: C");
        }

        sc.close();
    }
}