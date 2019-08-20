package div3_515;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskB {

	static int min = Integer.MAX_VALUE;
	static int n;
	static int r;
	static ArrayList<Integer> list;
	static int[] arr;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		r = sc.nextInt();
		list = new ArrayList<Integer>();
		arr = new int[n];
		int tmp;
		for (int i = 0; i < n; i++) {
			tmp = sc.nextInt();
//			arr[i] = 0;
			if (tmp == 1) {
				list.add(i);
			}
		}
		dfs(0, 0);
		if (min > list.size()) {
			System.out.println(-1);
		} else {
			System.out.println(min);
		}
	}

	public static void dfs(int cur, int heaters) {
		if (cur == n) {
			min = heaters < min ? heaters : min;
		}
		for (int i = 0; i < list.size(); i++) {
			if (heaters > min) {
				return;
			}
			int index = list.get(i);
			if (index == Integer.MAX_VALUE) {
				continue;
			}
			ArrayList<Integer> tmp = new ArrayList<Integer>();

			for (int j = index - r + 1; j <= index + r - 1; j++) {
				if (j < 0 || j >= n) {
					continue;
				}
				if (arr[j] == 0) {
					tmp.add(j);
					cur++;
					arr[j] = 1;
				}
			}
			list.set(i, Integer.MAX_VALUE);
			dfs(cur, heaters + 1);
			list.set(i, index);
			for (int j = 0; j < tmp.size(); j++) {
				arr[tmp.get(j)] = 0;
			}
			cur -= tmp.size();
		}

	}

}
