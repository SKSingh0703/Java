import java.util.Arrays;
import java.util.Scanner;

public class codeforces {
    import java.util.*;



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); // Number of test cases
        StringBuilder result = new StringBuilder();

        while (t-- > 0) {
            int n = sc.nextInt(); // Length of the array
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            // Sort the array
            Arrays.sort(a);

            // Check if all elements are equal
            if (a[0] == a[n - 1]) {
                result.append("NO\n");
            } else {
                result.append("YES\n");
            }
        }

        System.out.print(result.toString());
    }
}
