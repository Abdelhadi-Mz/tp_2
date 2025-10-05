package tp2;

import java.util.Scanner;

public class Max {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("Array size: ");
        int n = s.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements: ");
        for (int i = 0; i < n; i++) arr[i] = s.nextInt();
        int[] lis = new int[n];
        for (int i = 0; i < n; i++) lis[i] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && lis[i] < lis[j] + 1)
                    lis[i] = lis[j] + 1;
            }
        }
        int max = 0;
        for (int v : lis) if (v > max) max = v;
        System.out.println("Length of the longest increasing subsequence: " + max);
    }
}
