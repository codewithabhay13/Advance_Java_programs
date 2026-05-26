import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class KthLargestFactor {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter N and K (comma separated): ");
        String input = sc.nextLine();

        String parts[] = input.split(",");

        long N = Long.parseLong(parts[0]);
        int k = Integer.parseInt(parts[1]);

        ArrayList<Long> factors = new ArrayList<>();

        
        for (long i = 1; i <= Math.sqrt(N); i++) {

            if (N % i == 0) {

                factors.add(i);

                if (i != N / i) {
                    factors.add(N / i);
                }
            }
        }

        
        Collections.sort(factors, Collections.reverseOrder());

        
        if (k <= factors.size()) {
            System.out.println("Kth largest factor is: " + factors.get(k - 1));
        } else {
            System.out.println("1");
        }

        sc.close();
    }
}