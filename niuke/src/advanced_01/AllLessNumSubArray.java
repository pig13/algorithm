package advanced_01;

import java.util.LinkedList;

public class AllLessNumSubArray {

    public static int getNum(int[] arr, int num) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        LinkedList<Integer> qmin = new LinkedList<Integer>();
        LinkedList<Integer> qmax = new LinkedList<Integer>();
        int L = 0;
        int R = 0;
        int res = 0;
        while (L < arr.length) {
            while (R < arr.length) {
                while (!qmin.isEmpty() && arr[qmin.peekLast()] >= arr[R]) {
                    qmin.pollLast();
                }
                qmin.addLast(R);
                while (!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[R]) {
                    qmax.pollLast();
                }
                qmax.addLast(R);
                if (arr[qmax.getFirst()] - arr[qmin.getFirst()] > num) {
                    // 不达标
                    break;
                }
                R++;
            }
            // 不达标出来或者R跑完
            // 查看是否过期
            if (qmin.peekFirst() == L) {
                qmin.pollFirst();
            }
            if (qmax.peekFirst() == L) {
                qmax.pollFirst();
            }
            // 记录以L开头达标的子数组的数量
            res += R - L;
            L++;
        }
        return res;
    }
}
