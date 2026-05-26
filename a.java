import java.util.*;

public class a  {

    static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    static int getTotalX(int[] a, int[] b) {

        // Step 1: LCM of array a
        int lcmA = a[0];
        for (int i = 1; i < a.length; i++) {
            lcmA = lcm(lcmA, a[i]);
        }

        // Step 2: GCD of array b
        int gcdB = b[0];
        for (int i = 1; i < b.length; i++) {
            gcdB = gcd(gcdB, b[i]);
        }

        // Step 3: Count valid numbers
        int count = 0;

        for (int x = lcmA; x <= gcdB; x += lcmA) {
            if (gcdB % x == 0) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] a = {2, 4};
        int[] b = {16, 32, 96};

        System.out.println(getTotalX(a, b)); // Output: 3
    }
}