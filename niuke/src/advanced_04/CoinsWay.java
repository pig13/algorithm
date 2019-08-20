package advanced_04;

import java.util.HashMap;

public class CoinsWay {


    public static int coins1(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        return process1(arr, 0, aim);
    }

    // int[] arr : 不变数组
    // index: 可以自由使用index及其之后所有的钱
    // aim : 目标钱数
    // return ： 方法数
    // 第一版，暴力递归，暴力在重复计算
    public static int process1(int[] arr, int index, int aim) {
        int res = 0;
        if (index == arr.length) {
            res = aim == 0 ? 1 : 0;
        } else {
            for (int i = 0; arr[index] * i <= aim; i++) {
                res += process1(arr, index + 1, aim - arr[index] * i);
            }
        }
        return res;
    }

    // 记忆化，由上一版本分析出 无后效性(参数确定返回值确定) ，重复步骤不再计算
    public static int coins2(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        return process2(arr, 0, aim);

    }

    // 使用map实现记忆化，这里使用二维数组会更快.  因为要把 index与aim拼接作为key
    public static HashMap<String, Integer> map = new HashMap<>();

    public static int process2(int[] arr, int index, int aim) {
        int res = 0;
        if (index == arr.length) {
            res = aim == 0 ? 1 : 0;
        } else {
            for (int i = 0; arr[index] * i <= aim; i++) {
                String key = (index + 1) + "_" + (aim - arr[index] * i);
                if (map.containsKey(key)) {
                    res += map.get(key);
                } else {
                    int tmp = process2(arr, index + 1, aim - arr[index] * i);
                    map.put(key, tmp);
                    res += tmp;
                }
            }
        }
        return res;
    }


    // dp初步版
    public static int coins3(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        int[][] dp = new int[arr.length + 1][aim + 1];
        dp[arr.length][0] = 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j <= aim; j++) {
                int tmp = 0;
                for (int k = 0; j - arr[i] * k >= 0; k++) {
                    tmp += dp[i + 1][j - arr[i] * k];
                }
                dp[i][j] = tmp;
            }
        }
        return dp[0][aim];
    }

    // dp优化，分析其空间结构，确定其依赖，直接计算dp[i][j] 的值
    public static int coins4(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        int[][] dp = new int[arr.length + 1][aim + 1];
        dp[arr.length][0] = 1;
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j <= aim; j++) {
                dp[i][j] = dp[i + 1][j];
                dp[i][j] += j - arr[i] >= 0 ? dp[i][j - arr[i]] : 0;
            }
        }
        return dp[0][aim];
    }

    // dp空间优化版，看不懂的版本
    public static int coins5(int[] arr, int aim) {
        if (arr == null || arr.length == 0 || aim < 0) {
            return 0;
        }
        int[] dp = new int[aim + 1];
        for (int j = 0; arr[0] * j <= aim; j++) {
            dp[arr[0] * j] = 1;
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j <= aim; j++) {
                dp[j] += j - arr[i] >= 0 ? dp[j - arr[i]] : 0;
            }
        }
        return dp[aim];
    }


    public static void main(String[] args) {
        int[] coins = {10, 5, 1, 25};
        int aim = 2000;

        long start = 0;
        long end = 0;
        start = System.currentTimeMillis();
        System.out.println(coins1(coins, aim));
        end = System.currentTimeMillis();
        System.out.println("cost time : " + (end - start) + "(ms)");

        aim = 20000;
        start = System.currentTimeMillis();
        System.out.println(coins2(coins, aim));
        end = System.currentTimeMillis();
        System.out.println("cost time : " + (end - start) + "(ms)");


        start = System.currentTimeMillis();
        System.out.println(coins3(coins, aim));
        end = System.currentTimeMillis();
        System.out.println("cost time : " + (end - start) + "(ms)");

        start = System.currentTimeMillis();
        System.out.println(coins4(coins, aim));
        end = System.currentTimeMillis();
        System.out.println("cost time : " + (end - start) + "(ms)");

        start = System.currentTimeMillis();
        System.out.println(coins5(coins, aim));
        end = System.currentTimeMillis();
        System.out.println("cost time : " + (end - start) + "(ms)");
    }

}
