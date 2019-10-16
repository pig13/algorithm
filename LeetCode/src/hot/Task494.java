package hot;

import java.util.Set;
import java.util.HashMap;
import java.util.Map;

public class Task494 {


    public int ans = 0;

    public int findTargetSumWays(int[] nums, int S) {
        dfs(nums, 0, 0, S);
        return ans;
    }

    public void dfs(int[] arr, int level, int cur, int S) {
        if (level == arr.length) {
            if (cur == S) {
                ans++;
            }
            return;
        }
        dfs(arr, level + 1, cur + arr[level], S);
        dfs(arr, level + 1, cur - arr[level], S);
    }


}
