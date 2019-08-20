package luogu_search;

import java.util.Scanner;

public class P1605 {
	static int n;
	static int m;
	static boolean[][] map;
	static int startX;
	static int startY;
	static int endX;
	static int endY;
	static int total = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new boolean[n + 1][m + 1];
		int t = sc.nextInt();
		startX = sc.nextInt();
		startY = sc.nextInt();
		endX = sc.nextInt();
		endY = sc.nextInt();
		int x;
		int y;
		for (int i = 0; i < t; i++) {
			x = sc.nextInt();
			y = sc.nextInt();
			map[y][x] = true;
		}
		map[startY][startX] = true;
		dfs(startX, startY);
		System.out.println(total);
	}

	public static void dfs(int x, int y) {
		if (x == endX && y == endY) {
			total++;
			return;
		}
		if (x + 1 > 0 && x + 1 <= m && !map[y][x + 1]) {
			map[y][x + 1] = true;
			dfs(x + 1, y);
			map[y][x + 1] = false;

		}
		if (x - 1 > 0 && x - 1 <= m && !map[y][x - 1]) {
			map[y][x - 1] = true;
			dfs(x - 1, y);
			map[y][x - 1] = false;

		}
		if (y + 1 > 0 && y + 1 <= n && !map[y + 1][x]) {
			map[y + 1][x] = true;
			dfs(x, y + 1);
			map[y + 1][x] = false;
		}
		if (y - 1 > 0 && y - 1 <= n && !map[y - 1][x]) {
			map[y - 1][x] = true;
			dfs(x, y - 1);
			map[y - 1][x] = false;
		}

	}

}
