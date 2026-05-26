import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class PalindromeString {

    public static void main(String[] args) throws IOException {

        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter a string: ");
        String str = br.readLine();

        String rev = "";

        
        for (int i = str.length() - 1; i >= 0; i--) {

            rev = rev + str.charAt(i);

        }

        
        if (str.equalsIgnoreCase(rev)) {

            System.out.println("Palindrome String");

        } else {

            System.out.println("Not a Palindrome String");

        }
    }
}