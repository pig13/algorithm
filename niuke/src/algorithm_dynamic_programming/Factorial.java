package algorithm_dynamic_programming;

public class Factorial {

    public static int getFactorial1(int n) {
        int res = n;
        for (int i = 2; i < n; i++) {
            res *= i;
        }
        return res;
    }

    public static int getFactorial2(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * getFactorial2(n - 1);
        }
    }


    public static void main(String[] args) {
        System.out.println(getFactorial1(5));
        System.out.println(getFactorial2(5));

    }


}
