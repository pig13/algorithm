package div3_494;

import java.util.Scanner;

public class TaskC {
	public static void main(String[] args) {
		// 利用前缀和将 O(n^3) 降低为 O(n^2)
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int[] presum = new int[n + 1];
		for (int i = 1; i < presum.length; i++) {
			presum[i] = presum[i - 1] + arr[i - 1];
		}
		double ans = 0;
		double sum = 0;
		for (int i = k; i <= n; i++) {
			for (int j = i; j <= n; j++) {
				sum = presum[j] - presum[j - i];
				ans = sum / i > ans ? sum / i : ans;
			}
		}
		System.out.println(ans);
	}
}
