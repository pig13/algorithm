package luogu_search;

import java.util.Scanner;

public class P1162 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n][n];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				arr[i][j] = sc.nextInt();
				if (i > 0 && arr[i - 1][j] != 0 && j > 0 && arr[i][j - 1] != 0 && arr[i][j] != 1) {
					arr[i][j] = 2;
				}

			}
		}

		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

	}
}
