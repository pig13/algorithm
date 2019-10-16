package advanced_01;

public class Manacher {
    public static char[] manacherString(String str) {
        char[] charArr = str.toCharArray();
        char[] res = new char[str.length() * 2 + 1];
        res[0] = '#';
        int index = 0;
        for (int i = 1; i < res.length; i++) {
            res[i] = i % 2 == 0 ? '#' : charArr[index++];
        }
        return res;
    }

    public static int maxLcpsLength(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        char[] charArr = manacherString(str);
        int[] pArr = new int[charArr.length];  // 回文半径数组
        int R = -1; // 最右回文右边界
        int C = -1; // 最右回文右边界对应的回文中心
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < charArr.length; i++) {
            pArr[i] = R > i ? Math.min(pArr[2 * C - i], R - i) : 1;
            // 将四种情况合并为一种情况，真强
            // 2 * C - i -> i` ，i`是i关于C的对称点，pArr[2 * C - i] 即为i`点的回文半径
            // R - i，R-i的距离
            while (i + pArr[i] < charArr.length && i - pArr[i] > -1) {
                // 暴力扩
                // i + pArr[i] 当前已扩展的下一个，i - pArr[i] 当前已扩展的前一个
                if (charArr[i + pArr[i]] == charArr[i - pArr[i]]) {
                    pArr[i]++;
                } else {
                    break;
                }
            }
            if (i + pArr[i] > R) { // 更新最右回文边界
                C = i;
                R = i + pArr[i];
            }
            max = Math.max(max, pArr[i]);
        }
        return max - 1;
    }

    public static void main(String[] args) {
        System.out.println(Manacher.maxLcpsLength("ada"));

    }

}
