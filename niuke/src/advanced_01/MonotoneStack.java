package advanced_01;

import java.util.LinkedList;

import java.util.Stack;

public class MonotoneStack {

    public static int[][] findLeftAndRightBigger(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        int[][] res = new int[arr.length][2]; // 存储左边比他大且离他最近的下标res[i][0]，右边比他大且离他最近的下标res[i][1]
        Stack<LinkedList<Integer>> stack = new Stack<>(); // 栈中存LinkedList防止重复元素出现
        for (int i = 0; i < arr.length; i++) {
            // 为push准备
            while (!stack.isEmpty() && arr[stack.peek().peekFirst()] < arr[i]) {
                LinkedList<Integer> ll = stack.pop();
                while (!ll.isEmpty()) {
                    int index = ll.pop();
                    res[index][0] = stack.isEmpty() ? -1 : stack.peek().peekFirst(); // 左边比他大且离他最近的，-1表示不存在
                    res[index][1] = i;  // 右边比他大且离他最近的
                }
            }
            if (!stack.isEmpty() && arr[stack.peek().peekFirst()] == arr[i]) {
                stack.peek().add(i);
            } else {
                LinkedList<Integer> ll = new LinkedList<>();
                ll.add(i);
                stack.push(ll);
            }
        }
        // 弹出栈中剩余元素
        while (!stack.isEmpty()) {
            LinkedList<Integer> ll = stack.pop();
            while (!ll.isEmpty()) {
                int index = ll.pop();
                res[index][0] = stack.isEmpty() ? -1 : stack.peek().peekFirst(); // 左边比他大且离他最近的，-1表示不存在
                res[index][1] = -1;  // 右边比他大且离他最近的
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, -1, 0, 0, 0, 0};
        int[][] res = findLeftAndRightBigger(arr);
        for (int i = 0; i < arr.length; i++) {
            int left = res[i][0];
            int right = res[i][1];
            int leftValue = left == -1 ? Integer.MAX_VALUE : arr[left];
            int rightValue = right == -1 ? Integer.MIN_VALUE : arr[right];
            System.out.print(leftValue + "\t");
        }
        System.out.println();

        for (int i = 0; i < arr.length; i++) {
            int left = res[i][0];
            int right = res[i][1];
            int leftValue = left == -1 ? Integer.MAX_VALUE : arr[left];
            int rightValue = right == -1 ? Integer.MIN_VALUE : arr[right];
            System.out.print(rightValue + "\t");
        }
    }


}
