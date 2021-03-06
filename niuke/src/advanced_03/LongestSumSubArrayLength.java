package advanced_03;

import java.util.Arrays;
import java.util.HashMap;

public class LongestSumSubArrayLength {
    public static int maxLength(int[] arr, int aim) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0, -1); // important
        int maxLength = 0;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum - aim)) {
                maxLength = Math.max(i - map.get(sum - aim), maxLength);
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        return maxLength;
    }

    public static int[] generateArray(int size) {
        int[] result = new int[size];
        for (int i = 0; i != size; i++) {
            result[i] = (int) (Math.random() * 11) - 5;
        }
        return result;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i != arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = generateArray(20);
        System.out.println(Arrays.toString(arr));
        System.out.println(maxLength(arr, 10));

    }

}
