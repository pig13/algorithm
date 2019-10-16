package advanced_01;

import java.util.LinkedList;

public class SlidingWindowMaxArray {

    public static int[] getMaxWindow(int[] arr, int w) {
        if (arr == null || arr.length < w || w < 1) {
            return null;
        }
        LinkedList<Integer> qmax = new LinkedList<Integer>();
        int[] res = new int[arr.length - w + 1];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            // 为增大窗口做准备
            while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]) {
                qmax.pollLast();
            }
            // 增大窗口
            qmax.addLast(i);
            // 缩小窗口，当对队首元素过期时
            if (qmax.peekFirst() == i - w) {
                qmax.pollFirst();
            }
            // 记录值，从增加第w时开始
            if (i >= w - 1) {
                res[index++] = arr[qmax.peekFirst()];
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] arr = {4, 3, 5, 4, 3, 3, 6, 7};
        int[] res = getMaxWindow(arr, 3);
        for (int i : res) {
            System.out.print(i+" ");

        }
    }

}
