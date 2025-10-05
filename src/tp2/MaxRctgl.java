package tp2;

import java.util.Scanner;
import java.util.Deque;
import java.util.ArrayDeque;

public class MaxRctgl {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int totalRows = input.nextInt();
        int totalCols = input.nextInt();
        int[][] grid = new int[totalRows][totalCols];
        for (int r = 0; r < totalRows; r++)
            for (int c = 0; c < totalCols; c++)
                grid[r][c] = input.nextInt();

        int[] columnHeights = new int[totalCols];
        int maxArea = 0;
        int topRow = -1, leftCol = -1, bottomRow = -1, rightCol = -1;

        for (int row = 0; row < totalRows; row++) {
            for (int col = 0; col < totalCols; col++) {
                if (grid[row][col] == 1) columnHeights[col]++;
                else columnHeights[col] = 0;
            }

            Deque<Integer> indexStack = new ArrayDeque<>();
            for (int i = 0; i <= totalCols; i++) {
                int currentHeight = (i == totalCols) ? 0 : columnHeights[i];
                while (!indexStack.isEmpty() && currentHeight < columnHeights[indexStack.peek()]) {
                    int height = columnHeights[indexStack.pop()];
                    int leftBoundary = indexStack.isEmpty() ? 0 : indexStack.peek() + 1;
                    int rightBoundary = i - 1;
                    int area = height * (rightBoundary - leftBoundary + 1);
                    if (area > maxArea) {
                        maxArea = area;
                        topRow = row - height + 1;
                        bottomRow = row;
                        leftCol = leftBoundary;
                        rightCol = rightBoundary;
                    }
                }
                indexStack.push(i);
            }
        }

        if (maxArea == 0) {
            System.out.println("No rectangle of 1s found");
        } else {
            System.out.println("Area: " + maxArea);
            System.out.println("Top-left (0-based): (" + topRow + ", " + leftCol + ")");
            System.out.println("Bottom-right (0-based): (" + bottomRow + ", " + rightCol + ")");
            System.out.println("Top-left (1-based): (" + (topRow + 1) + ", " + (leftCol + 1) + ")");
            System.out.println("Bottom-right (1-based): (" + (bottomRow + 1) + ", " + (rightCol + 1) + ")");
        }

        input.close();
    }
}
