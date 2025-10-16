package tp2;

import java.util.Scanner;

public class SmMatriceDiag {
    public static int diagonalDifference(int[][] matrix, int size) {
        int sumPrimary = 0;
        int sumSecondary = 0;
        for (int i = 0; i < size; i++) {
            sumPrimary += matrix[i][i];
            sumSecondary += matrix[i][size - i - 1];
        }
        return Math.abs(sumPrimary - sumSecondary);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of the square matrix: ");
        int n = scanner.nextInt();
        int[][] mat = new int[n][n];
        System.out.println("Enter the matrix elements:");
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                mat[i][j] = scanner.nextInt();

        int result = diagonalDifference(mat, n);
        System.out.println("Absolute difference: " + result);
        scanner.close();
    }
}
