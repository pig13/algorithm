package hot;

import java.util.HashMap;
import java.util.Map;

public class Task560 {
    static public int subarraySum(int[] nums, int k) {
        int[] prexArr = new int[nums.length + 1];
        for (int i = 1; i < prexArr.length; i++) {
            prexArr[i] = prexArr[i - 1] + nums[i - 1];
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i < prexArr.length; i++) {
            if (map.containsKey(prexArr[i])) {
                map.put(prexArr[i], map.get(prexArr[i]) + 1);
            } else {
                map.put(prexArr[i], 1);
            }
        }
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(k)) {
                ans += Math.max(map.get(k), 0);
            }
            k += nums[i];
            map.put(prexArr[i + 1], map.get(prexArr[i + 1]) - 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int k = 3;
        System.out.println(subarraySum(arr, k));


    }

}
