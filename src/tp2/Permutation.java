package tp2;

import java.util.Scanner;

public class Permutation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = scanner.nextInt();

        boolean[] seen = new boolean[n + 1];
        boolean isValid = true;
        for (int num : arr) {
            if (num < 1 || num > n || seen[num]) {
                isValid = false;
                break;
            }
            seen[num] = true;
        }

        if (isValid) {
            int indexOne = -1;
            for (int i = 0; i < n; i++) {
                if (arr[i] == 1) {
                    indexOne = i;
                    break;
                }
            }
            for (int i = 0; i < n; i++) {
                int expected = ((i) % n) + 1;
                if (arr[(indexOne + i) % n] != expected) {
                    isValid = false;
                    break;
                }
            }
        }

        if (isValid) System.out.println("Valid circular permutation");
        else System.out.println("Invalid circular permutation");

        scanner.close();
    }
}
