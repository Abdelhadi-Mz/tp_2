package tp2;

import java.util.Scanner;

public class TabMax {
    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = inputScanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++)
            arr[i] = inputScanner.nextInt();

        int maxSum = arr[0];
        int currentSum = arr[0];
        for (int i = 1; i < n; i++) {
            currentSum = Math.max(arr[i], currentSum + arr[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        System.out.println("Maximum subarray sum: " + maxSum);
        inputScanner.close();
    }
}
