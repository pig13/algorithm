package advanced_03;

import java.util.LinkedList;

public class ExpressionCompute {
    public static int getValue(String str) {
        return process(str.toCharArray(), 0)[0];
    }
    // 返回值为数组，长度一定是2，(res,index)-->(计算的结果，已经计算到哪个位置)
    public static int[] process(char[] str, int i) {
        LinkedList<String> que = new LinkedList<String>();
        int pre = 0;    // 记录数字，从字符串中解析出数字
        int[] bra = null;
        while (i < str.length && str[i] != ')') {
            if (str[i] >= '0' && str[i] <= '9') {   // 收集数字
                pre = pre * 10 + str[i++] - '0';
            } else if (str[i] != '(') { // 遇到了 + - / *
                addNum(que, pre);
                que.addLast(String.valueOf(str[i++]));
                pre = 0;
            } else {    // 遇到了 (,递归计算()之间的值
                bra = process(str, i + 1);
                pre = bra[0];
                i = bra[1] + 1;
            }
        }
        addNum(que, pre);
        return new int[]{getNum(que), i};
    }

    public static void addNum(LinkedList<String> que, int num) {
        if (!que.isEmpty()) {
            int cur = 0;
            String top = que.pollLast();
            if (top.equals("+") || top.equals("-")) {
                que.addLast(top);
            } else {
                cur = Integer.valueOf(que.pollLast());
                num = top.equals("*") ? (cur * num) : (cur / num);
            }
        }
        que.addLast(String.valueOf(num));
    }

    public static int getNum(LinkedList<String> que) {
        int res = 0;
        boolean add = true;
        String cur = null;
        int num = 0;
        while (!que.isEmpty()) {
            cur = que.pollFirst();
            if (cur.equals("+")) {
                add = true;
            } else if (cur.equals("-")) {
                add = false;
            } else {
                num = Integer.valueOf(cur);
                res += add ? num : (-num);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String exp = "48*((70-65)-43)+8*1";
        System.out.println(getValue(exp));

        exp = "4*(6+78)+53-9/2+45*8";
        System.out.println(getValue(exp));

        exp = "10-5*3";
        System.out.println(getValue(exp));

        exp = "-3*4";
        System.out.println(getValue(exp));

        exp = "3+1*4";
        System.out.println(getValue(exp));

    }

}
