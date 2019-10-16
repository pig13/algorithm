package hot;

import java.util.*;

public class Task347 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.containsKey(nums[i]) ? map.get(nums[i]) + 1 : 1);
        }
        int[][] arr = new int[nums.length][2];
        final int[] index = {0};
        map.forEach((key, value) -> {
            arr[index[0]][0] = value;
            arr[index[0]][1] = key;
            index[0]++;
        });
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[0] - o1[0];
            }
        });
        LinkedList<Integer> ll = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            ll.add(arr[i][1]);
        }
        return ll;
    }

}
