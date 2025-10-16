package tp2;

import java.util.Scanner;

public class Freq {
    public static int findMajority(int[] arr) {
        int candidate = arr[0];
        int count = 1;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == candidate) count++;
            else count--;
            if (count == 0) {
                candidate = arr[i];
                count = 1;
            }
        }

        count = 0;
        for (int num : arr) {
            if (num == candidate) count++;
        }

        return (count > arr.length / 2) ? candidate : -1;
    }

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = inputScanner.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) arr[i] = inputScanner.nextInt();

        int majority = findMajority(arr);
        if (majority != -1) System.out.println("Majority element: " + majority);
        else System.out.println("No majority element");

        inputScanner.close();
    }
}
