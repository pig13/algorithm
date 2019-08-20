package luogu;

import java.util.ArrayList;
import java.util.Scanner;

public class P1464 {
	static long[][][] dp = new long[25][25][25];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> list = new ArrayList<String>();
		String tmp = sc.nextLine();
		for (; !tmp.trim().equals("-1 -1 -1");) {
			list.add(tmp);
			tmp = sc.nextLine();
		}
		String[] abc = new String[3];
		long a;
		long b;
		long c;
		for (int i = 0; i < list.size(); i++) {
			tmp = list.get(i);
			abc = tmp.split(" ");
			a = Long.parseLong(abc[0]);
			b = Long.parseLong(abc[1]);
			c = Long.parseLong(abc[2]);
			System.out.println("w(" + a + ", " + b + ", " + c + ") = " + w(a, b, c));
		}

	}

	static public long w(long a, long b, long c) {
		if (a <= 0 || b <= 0 || c < 0) {
			return 1;
		}
		if (a > 20 || b > 20 || c > 20) {
			return w(21, 21, 21);
//			if (dp[20][20][20] == 0) {
//				dp[20][20][20] = w(20, 20, 20);
//			}
//			return dp[20][20][20];
		}
		return w((int) a, (int) b, (int) c);
	}

	static public long w(int a, int b, int c) {
		if (a <= 0 || b <= 0 || c <= 0) {
			return 1;
		}
		if (a > 20 || b > 20 || c > 20) {
			if (dp[20][20][20] == 0) {
				dp[20][20][20] = w(20, 20, 20);
			}
			return dp[20][20][20];
		}

		if (a < b && b < c) {
			if (dp[a][b][(c - 1)] == 0) {
				dp[a][b][(c - 1)] = w(a, b, c - 1);
			}

			if (dp[a][(b - 1)][(c - 1)] == 0) {
				dp[a][(b - 1)][(c - 1)] = w(a, b - 1, c - 1);
			}

			if (dp[a][(b - 1)][c] == 0) {
				dp[a][(b - 1)][c] = w(a, b - 1, c);
			}
			return dp[a][b][(c - 1)] + dp[a][(b - 1)][(c - 1)] - dp[a][(b - 1)][c];
		} else {
			if (dp[(a - 1)][b][c] == 0) {
				dp[(a - 1)][b][c] = w(a - 1, b, c);
			}

			if (dp[(a - 1)][(b - 1)][c] == 0) {
				dp[(a - 1)][(b - 1)][c] = w(a - 1, b - 1, c);
			}

			if (dp[(a - 1)][b][(c - 1)] == 0) {
				dp[(a - 1)][b][(c - 1)] = w(a - 1, b, c - 1);
			}
			if (dp[(a - 1)][(b - 1)][(c - 1)] == 0) {
				dp[(a - 1)][(b - 1)][(c - 1)] = w(a - 1, b - 1, c - 1);
			}
			return dp[(a - 1)][b][c] + dp[(a - 1)][(b - 1)][c] + dp[(a - 1)][b][(c - 1)]
					- dp[(a - 1)][(b - 1)][(c - 1)];
		}

	}

}
