package tp2;

import java.util.Scanner;

public class Nbabs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) arr[i] = scanner.nextInt();

        boolean[] present = new boolean[n + 1];
        for (int num : arr) {
            if (num >= 1 && num <= n) present[num] = true;
        }

        System.out.print("Missing elements: ");
        for (int i = 1; i <= n; i++) {
            if (!present[i]) System.out.print(i + " ");
        }

        scanner.close();
    }
}

