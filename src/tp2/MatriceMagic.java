package tp2;

import java.util.Scanner;

public class MatriceMagic {
    public static boolean isMagicSquare(int[][] mat) {
        int targetSum = 0;
        for (int j = 0; j < 3; j++) targetSum += mat[0][j];

        for (int i = 1; i < 3; i++) {
            int rowSum = 0;
            for (int j = 0; j < 3; j++) rowSum += mat[i][j];
            if (rowSum != targetSum) return false;
        }

        for (int j = 0; j < 3; j++) {
            int colSum = 0;
            for (int i = 0; i < 3; i++) colSum += mat[i][j];
            if (colSum != targetSum) return false;
        }

        int diag1 = mat[0][0] + mat[1][1] + mat[2][2];
        int diag2 = mat[0][2] + mat[1][1] + mat[2][0];
        return diag1 == targetSum && diag2 == targetSum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] matrix = new int[3][3];
        System.out.println("Enter 3x3 matrix elements:");
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                matrix[i][j] = scanner.nextInt();

        if (isMagicSquare(matrix))
            System.out.println("The matrix is a magic square.");
        else
            System.out.println("The matrix is NOT a magic square.");

        scanner.close();
    }
}
