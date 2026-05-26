public class ReverseStringRecursion {

    static String reverse(String str) {
        if (str.isEmpty()) {
            return str;
        }

        return reverse(str.substring(1)) + str.charAt(0);
    }

    public static void main(String[] args) {
        String str = "hello";

        System.out.println("Original String: " + str);
        System.out.println("Reversed String: " + reverse(str));
    }
}


// Time Complexity: O(n)
// Space Complexity: O(n)
// (n recursive calls in stack