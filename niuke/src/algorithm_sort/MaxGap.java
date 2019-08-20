package algorithm_sort;

public class MaxGap {
    public static void main(String[] args) {
        System.out.println(bucket(11, 10, 1, 11));
        System.out.println(bucket(1, 10, 1, 11));

    }

    public static int maxGap(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        // 设计n+1个桶，保证最大差值不在桶内，鸽笼原理
        // 将n个数，等分到n+1桶里
        int len = arr.length;
        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }
        if (min == max) {
            return 0;
        }
        boolean[] hasNum = new boolean[len + 1];
        int[] maxs = new int[len + 1];
        int[] mins = new int[len + 1];

        int bid = 0;
        for (int i = 0; i < len; i++) {
            bid = bucket(arr[i], len, min, max);
            mins[bid] = hasNum[bid] ? Math.min(mins[bid], arr[i]) : arr[i];
            maxs[bid] = hasNum[bid] ? Math.max(maxs[bid], arr[i]) : arr[i];
            hasNum[bid] = true;
        }
        int res = 0;
        int lastMax = maxs[0];
        int i = 1;
        for (; i <= len; i++) {
            if (hasNum[i]) {
                res = Math.max(res, mins[i] - lastMax);
                lastMax = maxs[i];
            }
        }
        return res;
    }

    public static int bucket(long num, long len, long min, long max) {
        // 根据参数判断这个数应该放哪个桶
        // (num - min) / ((max-min)/len)
        return (int) ((num - min) * len / (max - min));
    }

}
