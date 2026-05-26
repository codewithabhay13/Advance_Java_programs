import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        
        boolean valid = Pattern.matches("^[1-9][0-9]{5}$", s);

        
        Matcher m = Pattern.compile("(\\d)(?=\\d\\1)").matcher(s);

        int count = 0;
        while (m.find()) {
            count++;
        }

        System.out.println(valid && count < 2);
    }
}