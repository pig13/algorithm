package advanced_01;

public class KMP {
    public static int getIndexOf(String s, String m) {
        // s是长串，m是短串
        if (s == null || m == null || m.length() < 1 || s.length() < m.length()) {
            return -1;
        }
        // 把s,m变为字符数组，便于其他语言理解
        char[] str1 = s.toCharArray();
        char[] str2 = m.toCharArray();
        // 初始化匹配字符的下表
        int i1 = 0;
        int i2 = 0;
        // 获取str2的next数组
        int[] next = getNextArray(str2);
        while (i1 < str1.length && i2 < str2.length) {
            if (str1[i1] == str2[i2]) {
                // 若当前字符匹配成功，两个指针右移，继续匹配
                i1++;
                i2++;
            } else if (next[i2] == -1) {
                // 若匹配不成功，且已经跳到str2的第一个字符，str1跳到 str1[1]
                i1++;
            } else {
                // 若匹配失败，根据next数组往前跳，跳到匹配的字符的最长前缀后缀匹配长度的下一个元素
                i2 = next[i2];
            }
        }
        // 如果匹配成功则 i2 == str2.length
        return i2 == str2.length ? i1 - i2 : -1;
    }

    public static int[] getNextArray(char[] str) {
        if (str.length == 1) {
            return new int[]{-1};
        }
        int[] next = new int[str.length];
        next[0] = -1;
        next[1] = 0;
        // 求第i个字符的next数组值
        int i = 2;
        // cn初始化时第i-1个元素 最长前缀后缀匹配的长度下一个元素的下标，也就是 next[i-1]
        int cn = 0;
        while (i < next.length) {
            if (str[i - 1] == str[cn]) {
                // 第i-1个元素与第cn个元素比较相同，则next[i] 为 cn+1, 当前最长前缀后缀匹配的长度+1
                next[i++] = ++cn;
            } else if (cn > 0) {
                // 若cn还可以往前跳，则跳到匹配失败的 最长前缀后缀匹配的长度下一个元素
                cn = next[cn];
            } else {
                // 已经跳到了第一个元素
                next[i++] = 0;
            }
        }
        return next;
    }

    public static void main(String[] args) {
        System.out.println(KMP.getIndexOf("asdasd", "das"));
        for (int i :KMP.getNextArray("abkababkabF".toCharArray())){
            System.out.print(i+",");
        }


    }

}
