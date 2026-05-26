import java.util.Scanner;

public class LoginSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Register
        System.out.println("===== REGISTER =====");

        System.out.print("Create Username: ");
        String savedUsername = sc.nextLine();

        System.out.print("Create Password: ");
        String savedPassword = sc.nextLine();

        System.out.println("\nRegistration Successful!");

        // Login
        System.out.println("\n===== LOGIN =====");

        System.out.print("Enter Username: ");
        String username = sc.nextLine();

        System.out.print("Enter Password: ");
        String password = sc.nextLine();

        // Check Login
        if(username.equals(savedUsername) &&
           password.equals(savedPassword)) {

            System.out.println("\nLogin Successful!");
            System.out.println("Starting Interview...\n");

        } else {

            System.out.println("\nInvalid Username or Password");
        }

        sc.close();
    }
}