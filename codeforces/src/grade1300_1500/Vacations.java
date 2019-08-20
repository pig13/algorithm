package grade1300_1500;

import java.util.Scanner;

public class Vacations {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			arr[i] = sc.nextInt();
		}
		int[][] dp = new int[102][4];
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[i].length; j++) {
				dp[i][j] = Integer.MAX_VALUE;
			}
		}
		dp[0][0] = dp[0][1] = dp[0][2] = 0;
		for (int i = 1; i <= n; i++) {
			if (arr[i] == 0) {
				dp[i][0] = Math.min(dp[i - 1][2], Math.min(dp[i - 1][0], dp[i - 1][1])) + 1;
			} else if (arr[i] == 1) {
				dp[i][0] = Math.min(dp[i - 1][2], Math.min(dp[i - 1][0], dp[i - 1][1])) + 1;
				dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]);
			} else if (arr[i] == 2) {
				dp[i][0] = Math.min(dp[i - 1][2], Math.min(dp[i - 1][0], dp[i - 1][1])) + 1;
				dp[i][2] = Math.min(dp[i - 1][1], dp[i - 1][0]);
			} else {
				dp[i][0] = Math.min(dp[i - 1][2], Math.min(dp[i - 1][0], dp[i - 1][1])) + 1;
				dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]);
				dp[i][2] = Math.min(dp[i - 1][1], dp[i - 1][0]);
			}
		}
		int ans = Math.min(dp[n][2], Math.min(dp[n][0], dp[n][1]));
		System.out.println(ans);

	}
}
