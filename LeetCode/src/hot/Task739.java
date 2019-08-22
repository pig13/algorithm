package hot;

import java.util.LinkedList;
import java.util.Stack;

public class Task739 {


    static public int[] dailyTemperatures(int[] T) {
        // 单调栈，每个元素离他最近比他大的数，限制在右边，
        if (T == null || T.length == 0) {
            return T;
        }
        int[] ans = new int[T.length];
        Stack<LinkedList<Integer>> stack = new Stack<LinkedList<Integer>>();
        for (int i = 0; i < T.length; i++) {
            if (stack.isEmpty() || stack.peek().isEmpty() || T[stack.peek().peek()] > T[i]) {
                LinkedList<Integer> ll = new LinkedList<Integer>();
                ll.add(i);
                stack.push(ll);
            } else if (T[stack.peek().peek()] < T[i]) {
                LinkedList<Integer> ll = stack.pop();
                while (!ll.isEmpty()) {
                    int tmp = ll.pop();
                    ans[tmp] = i - tmp;
                }
                i--;
            } else {
                stack.peek().push(i);
            }
        }
        return ans;
    }


    static public int[] dailyTemperatures2(int[] T) {
        int[] arr = T;
        int[] ans = new int[T.length];
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < T.length; i++) {
            while (!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                int tmp = stack.pop();
                ans[tmp] = i - tmp;
            }
            stack.push(i);
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] arr = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] ans = dailyTemperatures2(arr);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");

        }


    }


}


//*
//
// 根据每日 气温 列表，请重新生成一个列表，对应位置的输入是你需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替。
//
//例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
//
//提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
//
//来源：力扣（LeetCode）
//链接：https://leetcode-cn.com/problems/daily-temperatures
//著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
//
//
// *//
