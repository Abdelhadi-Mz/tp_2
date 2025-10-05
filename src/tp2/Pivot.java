package tp2;

import java.util.Scanner;

public class Pivot {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter array size: ");
        int size = input.nextInt();

        int[] numbers = new int[size];
        System.out.println("Enter the elements: ");
        for (int i = 0; i < size; i++) numbers[i] = input.nextInt();

        int[] maxLeft = new int[size];
        int[] minRight = new int[size];

        maxLeft[0] = numbers[0];
        for (int i = 1; i < size; i++) maxLeft[i] = Math.max(maxLeft[i - 1], numbers[i]);

        minRight[size - 1] = numbers[size - 1];
        for (int i = size - 2; i >= 0; i--) minRight[i] = Math.min(minRight[i + 1], numbers[i]);

        System.out.print("Pivots: ");
        boolean hasPivot = false;

        for (int i = 0; i < size; i++) {
            boolean leftCondition = (i == 0) || (maxLeft[i - 1] <= numbers[i]);
            boolean rightCondition = (i == size - 1) || (minRight[i + 1] >= numbers[i]);
            if (leftCondition && rightCondition) {
                System.out.print(numbers[i] + " ");
                hasPivot = true;
            }
        }

        if (!hasPivot) System.out.print("None");
    }
}

