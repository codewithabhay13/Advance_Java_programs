import java.util.*;

public class Main {

    public static void printRangoli(int n) {

        int width = 4 * n - 3;

        for(int i = 0; i < 2 * n - 1; i++) {

            int row = i < n ? i : 2 * n - 2 - i;

            StringBuilder sb = new StringBuilder();

            for(int j = n - 1; j > row; j--) {
                sb.append("-");
            }

            for(int j = n - 1; j >= row; j--) {
                sb.append((char)('a' + j));

                if(j != row)
                    sb.append("-");
            }

            for(int j = row + 1; j < n; j++) {
                sb.append("-");
                sb.append((char)('a' + j));
            }

            while(sb.length() < width) {
                sb.insert(0, "-");
                if(sb.length() < width)
                    sb.append("-");
            }

            System.out.println(sb);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        printRangoli(n);
    }
}