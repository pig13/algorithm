package luogu;

import java.util.LinkedList;
import java.util.Scanner;

public class P2089 {
	static int count = 0;
	static int num;
	static LinkedList<String> list;
	static String[] ke = { "1 ", "2 ", "3 " };

	public static void main(String[] args) {
		list = new LinkedList<String>();
		Scanner sc = new Scanner(System.in);
		num = sc.nextInt();
		if (num > 30 || num < 10) {
			System.out.println(0);
			return;
		}
		dfs(0, "", 0);
		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).trim());
		}
	}

	public static void dfs(int depth, String res, int cur) {
		if (cur > num) {
			return;
		}
		if (depth == 10) {
			if (cur == num) {
//				System.out.println(cur);
				list.add(res);
			}
			return;
		}
		for (int i = 0; i < 3; i++) {
			dfs(depth + 1, res + ke[i], cur + i + 1);
		}

	}

}
