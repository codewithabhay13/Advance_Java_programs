import java.util.Scanner;

public class InterviewSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int score = 0;

        System.out.println("=== AI Mock Interview ===");

        // Question 1
        System.out.println("Q1. What is Java?");
        String ans1 = sc.nextLine();

        if(ans1.toLowerCase().contains("programming")) {
            score += 5;
        }

        // Question 2
        System.out.println("Q2. What is OOP?");
        String ans2 = sc.nextLine();

        if(ans2.toLowerCase().contains("object")) {
            score += 5;
        }

        System.out.println("Final Score: " + score + "/10");

        sc.close();
    }
}