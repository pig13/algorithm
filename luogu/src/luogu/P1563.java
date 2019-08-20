package luogu;

import java.util.Scanner;

public class P1563 {
	static int[] flag;
	static String[] name;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		flag = new int[n];
		name = new String[n];
		for (int i = 0; i < n; i++) {
			flag[i] = sc.nextInt();
			name[i] = sc.next();
		}
		int index = 0;
		for (int i = 0; i < m; i++) {
			index = next(index, sc.nextInt(), sc.nextInt());
		}
		System.out.println(name[index]);

	}

	public static int next(int cur, int direction, int pace) {
		if (!(flag[cur] == direction)) {
//++
			return (cur + pace) % flag.length;
		} else {
			if (cur - pace >= 0) {
				return cur - pace;
			} else {
				return flag.length - (Math.abs(cur - pace) % flag.length);
			}

		}

	}

}
