package algorithm_dynamic_programming;

public class Cow {
    public static int cowNumber1(int n) {
        if (n < 1) {
            return 0;
        }
        if (n < 4) {
            return n;
        }
        return cowNumber1(n - 1) + cowNumber1(n - 3);
    }

    public static int cowNumber2(int n) {
        if (n < 1) {
            return 0;
        }
        if (n < 4) {
            return n;
        }
        // [.....,prepre,pre,res,n]
        int res = 3;
        int pre = 2;
        int prepre = 1;
        int tmp1 = 0;
        int tmp2 = 0;
        for (int i = 4; i <= n; i++) {
            tmp1 = res;
            tmp2 = pre;
            res = res + prepre;
            pre = tmp1;
            prepre = tmp2;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(cowNumber1(20));
        System.out.println(cowNumber2(20));

    }

}
