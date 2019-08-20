package luogu_search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class P1219八皇后 {
	static int n = 8;
	static int total = 0;
	static int[] C = new int[n];
	static boolean[][] vis = new boolean[3][2 * n];
	static ArrayList<String> res = new ArrayList<String>();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		C = new int[n];
		vis = new boolean[3][2 * n];
		search2(0);
		for (int i = 0; i < res.size() && i < 3; i++) {
			System.out.println(res.get(i));
		}
		System.out.println(total);
	}

	public static void search(int cur) {
		if (cur == n) {
			total++; // 递归边界，走到了这里， 皇后必然不冲突
		} else {
			for (int i = 0; i < n; i++) {
				boolean ok = true;
				C[cur] = i; // 尝试把皇后放在cur行的第i列
				for (int j = 0; j < cur; j++) {
					if (C[cur] == C[j] || cur - C[cur] == j - C[j] || cur + C[cur] == j + C[j]) {
						// C[cur] == C[j]查看皇后是否在同一列上
						// cur - C[cur] == j - C[j] || cur + C[cur] == j +
						// C[j]查看皇后(cur,C[cur]),(j,C[j])是否在同一主副对角线上
						// 同一主对角线上的行列差值相同， 同一副对角线上的行列和值相同
						ok = false;
						break;
					}
				}
				if (ok) {
					search(cur + 1); // 如果合法，继续递归
				}

			}
		}
	}

	public static void search2(int cur) {
		if (cur == n) {
			total++; // 递归边界，走到了这里，所有皇后必然不冲突
			String ss = "";
			for (int i = 0; i < C.length; i++) {
				ss += C[i] + 1 + " ";
			}
			res.add(ss.trim());

		} else {
			for (int i = 0; i < n; i++) {
				// cur 行，i 列 (cur,i)
				if (!vis[0][i] && !vis[1][cur + i] && !vis[2][cur - i + n]) {
					C[cur] = i; // 如果不需要打印解，完全可以去掉
					vis[0][i] = vis[1][cur + i] = vis[2][cur - i + n] = true;
					search2(cur + 1); // 如果合法，继续递归
					vis[0][i] = vis[1][cur + i] = vis[2][cur - i + n] = false;
				}
			}
		}
	}

}
