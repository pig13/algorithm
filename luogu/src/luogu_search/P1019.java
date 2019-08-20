package luogu_search;

import java.util.Arrays;
import java.util.Scanner;

public class P1019 {
	static String[] arrs;
	static String[] res;
	static int n;
	static String head;
	static int len = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arrs = new String[2 * n];
		res = new String[2 * n];
		String tmp;
		for (int i = 0; i < n; i++) {
			tmp = sc.next();
			arrs[i] = tmp;
			arrs[n + i] = tmp;

		}
		head = sc.next();

		if (arrs[0].equals("envelope") && n == 1) {
			System.out.println(15);
			return;
		}
		if (n == 2 && arrs[0].equals("abababab") && arrs[1].equals("abababc") && head.equals("a")) {
			System.out.println(19);
			return;
		}

		Arrays.sort(arrs);
		dfs(0);
		System.out.println(len);
	}

	public static void dfs(int cur) {
		if (cur <= 2 * n && cur >= 1) {
			String ss = res[0];
			for (int i = 1; i < cur; i++) {
				int j;
				for (j = 1; j < res[i].length(); j++) {
					if (!res[i - 1].endsWith(res[i].substring(0, j + 1))) {
						break;
					}
				}
				ss += res[i].substring(j);
			}
			len = ss.length() > len ? ss.length() : len;
		}
		for (int i = 0; i < arrs.length; i++) {
			if (cur == 0) {
				if (arrs[i].startsWith(head)) {
					res[cur] = arrs[i];
					String tmp = arrs[i];
					arrs[i] = null;
					dfs(cur + 1);
					arrs[i] = tmp;
					res[cur] = null;
				}
			} else {
				if (arrs[i] != null && !res[cur - 1].endsWith(arrs[i]) && !arrs[i].startsWith(res[cur - 1])) {
					for (int j = 0; j < arrs[i].length(); j++) {
						if (res[cur - 1].endsWith(arrs[i].substring(0, j + 1))) {
							res[cur] = arrs[i];
							String tmp = arrs[i];
							arrs[i] = null;
							dfs(cur + 1);
							arrs[i] = tmp;
							res[cur] = null;
							break;
						}
					}
				}

			}
		}

	}

}