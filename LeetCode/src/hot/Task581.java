package hot;

public class Task581 {
    static public int findUnsortedSubarray(int[] nums) {
        if (nums == null || nums.length == 1) {
            return 0;
        }
        if (nums[0] > nums[nums.length - 1]) {
            return nums.length;
        }
        int left = 0;
        int right = nums.length - 1;
        int ans = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[left] > nums[i]) {
                break;
            } else {
                left++;
            }
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[right] < nums[i]) {
                break;
            } else {
                right--;
            }
        }
        if (right == -1) {
            return 0;
        }
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = left; i <= right; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
        }
        while (left >= 0 && nums[left] > min) {
            left--;
        }
        while (right < nums.length && nums[right] < max) {
            right++;
        }
        return Math.max(0, right - left - 1);
    }

    public static void main(String[] args) {
        int[] arr = {2, 6, 4, 8, 10, 9, 15};
        System.out.println(findUnsortedSubarray(arr));

    }

}
