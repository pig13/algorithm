package advanced_04;

import java.util.Arrays;

public class Ksum {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int k = 3;
        int target = 6;
        int ans = process(arr, 0, k, target);
        System.out.println(ans);


    }

    // 暴力递归版，需要改成三维dp
    public static int process(int[] arr, int index, int k, int target) {
        if (arr == null || arr.length == 0 || arr.length < k || k <= 0) {
            return 0;
        }
        if (k == 1) {
            for (int i = index; i < arr.length; i++) {
                if (target == arr[i]) {
                    return 1;
                }
            }
        }
        int ans = 0;
        for (int i = index; i < arr.length && arr[i] * 2 <= target; i++) {
            ans += process(arr, i + 1, k - 1, target - arr[i]);
        }
        return ans;

    }

    public class Solution {
        /**
         * @param A:      An integer array
         * @param k:      A positive integer (k <= length(A))
         * @param target: An integer
         * @return: An integer
         */
        public int kSum(int[] A, int k, int target) {
            // write your code here
            int[] arr = A;
            Arrays.sort(arr);
            int ans = 0;
            ans = process(arr, 0, k, target);
            return ans;
        }
    }


}
