package hot;

public class Task647 {
    // 找一个字符串中回文子串的个数，采用中心扩展法，考虑奇偶性
    // 中心扩展法，从每个位置向两边扩展，找到以这个位置为中心的回文串个数；奇偶性，回文串的对称中心不一致
    // 为什能找全？ 不会多找，也不会少找？ 当字符串长度为N时，一共可能有2N-1个对称轴，对每个对称轴做检查即可
    public int countSubstrings(String s) {
        char[] arr = s.toCharArray();
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            ans += find(arr, i, i);
            ans += find(arr, i, i + 1);
        }
        return ans;
    }

    public static int find(char[] arr, int i, int j) {
        int count = 0;
        while (i >= 0 && j < arr.length && i <= j && arr[i] == arr[j]) {
            count++;
            i--;
            j++;
        }
        return count;
    }

}
