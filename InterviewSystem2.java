import java.util.Scanner;

public class InterviewSystem2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String questions[] = {
            "What is Java?",
            "What is OOP?",
            "What is Inheritance?",
            "What is Polymorphism?"
        };

        String keywords[] = {
            "programming",
            "object",
            "class",
            "many"
        };

        int score = 0;

        System.out.println("=== AI Mock Interview ===");

        for(int i = 0; i < questions.length; i++) {

            System.out.println("Q" + (i + 1) + ". " + questions[i]);

            String answer = sc.nextLine();

            if(answer.toLowerCase().contains(keywords[i])) {
                score += 5;
                System.out.println("Correct Answer\n");
            } else {
                System.out.println("Needs Improvement\n");
            }
        }

        System.out.println("Final Score: " + score + "/" + (questions.length * 5));

        sc.close();
    }
}