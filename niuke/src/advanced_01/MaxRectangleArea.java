package advanced_01;

import java.util.Arrays;
import java.util.Stack;

public class MaxRectangleArea {
    public static int maxRectangleArea(int matrix[][]) {
        int arr[] = new int[matrix[0].length];
        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                arr[j] = matrix[i][j] == 1 ? arr[j] + 1 : 0;
            }
            System.out.println(Arrays.toString(arr));
            maxArea = Math.max(maxArea, maxRecAreaOfThRow(arr));
        }
        return maxArea;
    }

    public static int maxRecAreaOfThRow(int arr[]) {
        int maxArea = Integer.MIN_VALUE;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            while (!stack.empty() && arr[i] < arr[stack.peek()]) {
                int index = stack.pop();
                int leftBorder = stack.empty() ? -1 : stack.peek();     // leftBorder左边界，i右边界
                maxArea = Math.max(maxArea, arr[index] * (i - leftBorder - 1));
            }
            stack.push(i);
        }
        while (!stack.empty()) {
            int index = stack.pop();
            int rightBorder = arr.length;     // 右边界
            int leftBorder = stack.empty() ? -1 : stack.peek();  // 左边界
            maxArea = Math.max(maxArea, arr[index] * (rightBorder - leftBorder - 1));
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int matrix[][] = {{0, 0, 0, 0, 1}, {0, 0, 0, 0, 1}, {1, 0, 0, 0, 1}, {1, 0, 1, 0, 1}, {1, 1, 1, 0, 1}, {1, 1, 1, 1, 1}};
        System.out.println(maxRectangleArea(matrix));//6
    }
}
