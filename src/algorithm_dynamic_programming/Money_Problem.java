package algorithm_dynamic_programming;

public class Money_Problem {
    /*
     *
     *
     * Money_Problem
     *
     * 给你一个数组arr，和一个整数aim。如果可以任意选择arr中的
     * 数字，能不能累加得到aim，返回true或者false
     *
     */
    public static boolean money1(int[] arr, int aim) {
        return process1(arr, aim, 0, 0);
    }

    public static boolean process1(int[] arr, int aim, int sum, int i) {
        if (aim == sum) {
            return true;
        }
        if (i == arr.length) {
            return false;
        }
        return process1(arr, aim, sum, i + 1) || process1(arr, aim, sum + arr[i], i + 1);
    }


    public static void main(String[] args) {
        int[] arr = {1, 4, 8};
        int aim = 11;
        System.out.println(money1(arr, aim));
//        System.out.println(money2(arr, aim));
    }
}
