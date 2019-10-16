package offer;

public class Find {

    public class Solution {
        public boolean Find(int target, int[][] array) {
            if (array == null || array.length == 0) {
                return false;
            }
            int i = 0;
            int j = array[0].length - 1;
            boolean flag = false;
            while (i < array.length && j >= 0) {
                if (array[i][j] == target) {
                    flag = true;
                    break;
                } else if (array[i][j] > target) {
                    j--;
                } else {
                    i++;
                }
            }
            return flag;
        }
    }
}
