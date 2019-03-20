package day01;

public class MaxGap {
    public static void main(String[] args) {

    }

    public static int maxGap(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        // 设计n+1个桶，保证最大差值不在桶内
        // todo bucket函数，设置n个桶，与设计n+1个桶一样吗
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

        return 1;
    }

    public static int bucket(long num, long len, long min, long max) {
        return (int) ((num - min) * len / (max - min));
    }

}
