import java.util.ArrayList;
import java.util.Scanner;

public class BinarySearchArrayList {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ArrayList<Integer> list = new ArrayList<>();

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        System.out.println("Enter sorted elements:");

        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        System.out.print("Enter element to search: ");
        int key = sc.nextInt();

        int low = 0;
        int high = list.size() - 1;
        int found = -1;

        while (low <= high) {

            int mid = (low + high) / 2;

            if (list.get(mid) == key) {
                found = mid;
                break;
            }
            else if (list.get(mid) < key) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        if (found != -1) {
            System.out.println("Element found at index: " + found);
        } else {
            System.out.println("Element not found");
        }

        sc.close();
    }
}