// 

import java.util.ArrayList;
import java.util.Scanner;

public class LeaderElementArrayList {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> leaders = new ArrayList<>();

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        System.out.println("Enter elements:");

        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        int maxFromRight = list.get(n - 1);
        leaders.add(maxFromRight);

        for (int i = n - 2; i >= 0; i--) {

            if (list.get(i) > maxFromRight) {
                maxFromRight = list.get(i);
                leaders.add(maxFromRight);
            }
        }

        System.out.println("Leader elements are:");

        for (int i = leaders.size() - 1; i >= 0; i--) {
            System.out.print(leaders.get(i) + " ");
        }

        sc.close();
    }
}