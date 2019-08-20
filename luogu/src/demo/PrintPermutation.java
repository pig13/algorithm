package demo;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class PrintPermutation {
	static PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

	public static void main(String[] args) {
		int[] arr = new int[122];
		char[] arr3 = new char[33];
//		char[] arr2 = { 'a', 'b', 'c', 'd', 'e' }; // 先sort一遍
		char[] arr2 = { 'a', 'a', 'b' }; // 先sort一遍
//		printPermutation(9, arr, 0);
//		printPermutation(arr2.length, arr2, arr3, 0);
		pw.flush();

		char[] arr4 = { 'q', 'w', 'e' };
		for (int i = 0; i < (1 << arr4.length); i++) {
			printSubset(arr4, arr4.length, i);

		}

	}

	public static void printPermutation(int n, int[] arr, int cur) {
		// 全排列1-n
		if (cur == n) {
			for (int i = 0; i < n; i++) {
				pw.append(arr[i] + "");
			}
			pw.append("\n");
			return;
		}
		for (int i = 1; i <= n; i++) {
			boolean ok = true;
			for (int j = 0; j < cur; j++) {
				if (arr[j] == i) {
					ok = false;
				}
			}
			if (ok) {
				arr[cur] = i;
				printPermutation(n, arr, cur + 1);
			}
		}

	}

	public static void printPermutation(int n, char[] P, char[] arr, int cur) {
		// 全排列字符序列
		if (cur == n) {
			for (int i = 0; i < n; i++) {
				pw.append(arr[i] + "");
			}
			pw.append("\n");
			return;
		}
		for (int i = 0; i < n; i++) {
			if (i == 0 || P[i] != P[i - 1]) {
				// 避免重复
				int c1 = 0, c2 = 0;
				// 查看这个字符出现的几次，是否能在出现
				for (int j = 0; j < cur; j++) {
					if (arr[j] == P[i]) {
						c1++;
					}
				}
				for (int j = 0; j < n; j++) {
					if (P[i] == P[j]) {
						c2++;
					}
				}
				if (c1 < c2) {
					arr[cur] = P[i];
					printPermutation(n, P, arr, cur + 1);
				}
			}

		}

	}

	public static void printSubset(char[] arr, int N, int seq) {
//		枚举子集，二进制法
		for (int i = 0; i < N; i++) {
			if ((seq & (1 << i)) != 0) {
				System.out.print(arr[i]);
			}
		}
		System.out.println();

	}

}
