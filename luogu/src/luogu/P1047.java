package luogu;

import java.util.Scanner;

public class P1047 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt();
		int M = sc.nextInt();
		boolean[] tree = new boolean[L + 1];
		int left;
		int right;
		for (int i = 0; i < M; i++) {
			left = sc.nextInt();
			right = sc.nextInt();
			for (int j = left; j <= right; j++) {
				tree[j] = true;
			}

		}
		int count = 0;
		for (int i = 0; i < tree.length; i++) {
			if (tree[i] == false) {
				count++;
			}
		}
		System.out.println(count);

	}
}
