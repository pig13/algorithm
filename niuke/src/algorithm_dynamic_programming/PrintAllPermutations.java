package algorithm_dynamic_programming;

import java.util.HashSet;

public class PrintAllPermutations {


    // 全排列就是从第一个数字起每个数分别与它后面的数字交换
    public static void printAllPermutations(String str) {
        char[] chs = str.toCharArray();
        process(chs, 0);
    }

    public static void process(char[] chs, int i) {
        if (i == chs.length) {
            System.out.println(String.valueOf(chs));
            return;
        }
        // 去重的全排列就是从第一个数字起每个数分别与它后面非重复出现的数字交换
        HashSet<Character> set = new HashSet<>();
        for (int j = i; j < chs.length; j++) {
            if (!set.contains(chs[j])) {
                set.add(chs[j]);
                swap(chs, i, j);
                process(chs, i + 1);
                swap(chs, i, j);
            }
        }
    }

    public static void swap(char[] chs, int i, int j) {
        char tmp = chs[i];
        chs[i] = chs[j];
        chs[j] = tmp;
    }


    public static void main(String[] args) {
        String test1 = "aaa";
        printAllPermutations(test1);
        String test2 = "aasdsd";
        printAllPermutations(test2);
    }
}
