package tp2;

import java.util.Scanner;

public class MatriceSpirale {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter matrix size: ");
        int size = input.nextInt();

        int[][] matrix = new int[size][size];
        int startRow = 0, endRow = size - 1;
        int startCol = 0, endCol = size - 1;
        int num = 1;

        while (num <= size * size) {
            for (int col = startCol; col <= endCol && num <= size * size; col++)
                matrix[startRow][col] = num++;
            startRow++;

            for (int row = startRow; row <= endRow && num <= size * size; row++)
                matrix[row][endCol] = num++;
            endCol--;

            for (int col = endCol; col >= startCol && num <= size * size; col--)
                matrix[endRow][col] = num++;
            endRow--;

            for (int row = endRow; row >= startRow && num <= size * size; row--)
                matrix[row][startCol] = num++;
            startCol++;
        }

        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.printf("%4d", matrix[row][col]);
            }
            System.out.println();
        }

        input.close();
    }
}

