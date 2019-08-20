package advanced_03;

import java.util.HashMap;

public class Most_EOR {
    public static int mostEOR(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int xor = 0;
        int[] dp = new int[arr.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < arr.length; i++) {
            xor ^= arr[i];
            if (map.containsKey(xor)) {
                // case 2
                int pre = map.get(xor);
                dp[i] = pre == -1 ? 1 : (dp[pre] + 1);
            }
            if (i > 0) {
                // case 1 并且 dp在两种策略中选最大
                dp[i] = Math.max(dp[i - 1], dp[i]);
            }
            map.put(xor, i);
        }
        // 最后一个位置的dp就是整个问题的解
        return dp[arr.length - 1];
    }

    public static int maxSubArrs(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        HashMap<Integer, Integer> map = new HashMap();
        map.put(0, -1);
        int curXorSum = 0;
        int[] dp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            curXorSum ^= arr[i];
            //case 1，之前没有出现过这个异或和，那么该位置上的dp等于前一个位置的dp
            if (!map.containsKey(curXorSum)) {
                dp[i] = i > 0 ? dp[i - 1] : 0;
            } else {
                //case 2，之前出现过这个异或和，那么之前这个异或和出现的位置到当前位置形成的子数组异或和为0
                int index = map.get(curXorSum);
                dp[i] = index == -1 ? 1 : dp[index] + 1;
            }
            // dp在两种策略中选最大
            if (i > 0) {
                dp[i] = Math.max(dp[i - 1], dp[i]);
            }
            //把最近出现的异或和都记录下来，因为要划分出最多的异或和为0的子数组
            map.put(curXorSum, i);
        }
        //最后一个位置的dp就是整个问题的解
        return dp[dp.length - 1];
    }


    // for test
    public static int comparator(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        int[] eors = new int[arr.length];
        int eor = 0;
        for (int i = 0; i < arr.length; i++) {
            eor ^= arr[i];
            eors[i] = eor;
        }
        int[] mosts = new int[arr.length];
        mosts[0] = arr[0] == 0 ? 1 : 0;
        for (int i = 1; i < arr.length; i++) {
            mosts[i] = eors[i] == 0 ? 1 : 0;
            for (int j = 0; j < i; j++) {
                if ((eors[i] ^ eors[j]) == 0) {
                    mosts[i] = Math.max(mosts[i], mosts[j] + 1);
                }
            }
            mosts[i] = Math.max(mosts[i], mosts[i - 1]);
        }
        return mosts[mosts.length - 1];
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random());
        }
        return arr;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // for test
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr = generateRandomArray(maxSize, maxValue);
            int res = mostEOR(arr);
//            int res = maxSubArrs(arr);
            int comp = comparator(arr);
            if (res != comp) {
                succeed = false;
                printArray(arr);
                System.out.println(res);
                System.out.println(comp);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }

}
