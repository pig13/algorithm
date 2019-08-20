package luogu;

import java.util.Scanner;

public class P1328 {
	static int[][] flag = { { 0, -1, 1, 1, -1 }, { 1, 0, -1, 1, -1 }, { -1, 1, 0, -1, 1 }, { -1, -1, 1, 0, 1, },
			{ 1, 1, -1, -1, 0 } };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		int[] arrA = new int[a];
		int[] arrB = new int[b];

		for (int i = 0; i < arrA.length; i++) {
			arrA[i] = sc.nextInt();
		}
		for (int i = 0; i < arrB.length; i++) {
			arrB[i] = sc.nextInt();
		}
		int gradeA = 0;
		int gradeB = 0;
		int curA = 0;
		int curB = 0;
		int tmp;
		for (int i = 0; i < n; i++) {
			tmp = flag[arrA[curA]][arrB[curB]];
			if (tmp == 1) {
				gradeA++;
			} else if (tmp == -1) {
				gradeB++;
			}
			curA = next(arrA, curA);
			curB = next(arrB, curB);
		}
		System.out.println(gradeA + " " + gradeB);

	}

	public static int next(int[] arr, int cur) {
		if (cur + 1 == arr.length) {
			return 0;
		} else {
			return cur + 1;
		}
	}

}
