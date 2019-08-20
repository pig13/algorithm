package advanced_04;

public class RobotWalkWays {
    public static int process(int n, int cur, int p, int k) {
        if (Math.abs(cur - k) > p) {
            return 0;
        }
        if (k == cur && p == 0) {
            return 1;
        }
        if (cur == 1) {
            return process(n, cur + 1, p - 1, k);
        }
        if (cur == n) {
            return process(n, cur - 1, p - 1, k);
        }
        return process(n, cur - 1, p - 1, k) + process(n, cur + 1, p - 1, k);
    }

    public static int robotWalkWaysDp(int n, int m, int p, int k) {
        int[][] dp = new int[n][p + 1];
        dp[k - 1][0] = 1;
        for (int col = 1; col < p + 1; col++) {
            for (int row = 0; row < n; row++) {
                int tmp1 = row > 0 ? dp[row - 1][col - 1] : 0;
                int tmp2 = row < n - 1 ? dp[row + 1][col - 1] : 0;
                dp[row][col] = tmp1 + tmp2;
            }
        }
        return dp[m - 1][p];
    }


    public static void main(String[] args) {
        System.out.println(process(5, 2, 3, 3));
        System.out.println(robotWalkWaysDp(5, 2, 3, 3));
    }
}
