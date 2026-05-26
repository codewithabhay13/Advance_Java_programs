import java.util.HashSet;

public class FirstRepeating {
    public static void main(String[] args) {
        int arr[] = {4, 5, 1, 2, 5, 1};

        HashSet<Integer> set = new HashSet<>();

        for (int num : arr) {
            if (set.contains(num)) {
                System.out.println("First Repeating Element: " + num);
                break;
            } else {
                set.add(num);
            }
        }
    }
}