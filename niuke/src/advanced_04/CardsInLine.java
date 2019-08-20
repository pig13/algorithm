package advanced_04;

import java.awt.geom.Area;

public class CardsInLine {

    public static int maxScoreOfWinner(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        return Math.max(
                f(arr, 0, arr.length - 1),
                s(arr, 0, arr.length - 1)
        );
    }

    public static int f(int[] arr, int begin, int end) {
        if (begin == end) {
            return arr[begin];
        }
        return Math.max(
                arr[begin] + s(arr, begin + 1, end),
                arr[end] + s(arr, begin, end - 1)
        );
    }

    public static int s(int[] arr, int begin, int end) {
        if (begin == end) {
            return 0;
        }
        return Math.min(
                f(arr, begin + 1, end),
                f(arr, begin, end - 1)
        );
    }

    public static int maxScoreOfWinner2(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int[][] dpf = new int[arr.length][arr.length];
        int[][] dps = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++) {
            dpf[i][i] = arr[i];
            dps[i][i] = 0;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int row = 0; row < arr.length - i; row++) {
                int col = i + row;
                dpf[row][col] = Math.max(
                        arr[row] + dps[row + 1][col],
                        arr[col] + dps[row][col - 1]
                );
                dps[row][col] = Math.min(
                        dpf[row + 1][col],
                        dpf[row][col - 1]
                );
            }
        }
        return Math.max(dps[0][arr.length - 1], dpf[0][arr.length - 1]);
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 100, 4};
        System.out.println(maxScoreOfWinner(arr));//101
        System.out.println(maxScoreOfWinner2(arr));//101
    }

}
