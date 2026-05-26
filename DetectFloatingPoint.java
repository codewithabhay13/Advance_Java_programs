import java.util.Scanner;

public class DetectFloatingPoint {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        String input = sc.nextLine();

        String regex = "[+-]?((\\d+\\.\\d+)|(\\.\\d+))";

        if (input.matches(regex)) {

            try {

                Float.parseFloat(input);

                System.out.println("Valid Floating Point Number");

            } catch (NumberFormatException e) {

                System.out.println("Invalid Floating Point Number");
            }

        } else {

            System.out.println("Invalid Floating Point Number");
        }

        sc.close();
    }
}