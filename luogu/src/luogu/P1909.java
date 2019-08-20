package luogu;

import java.util.Scanner;

public class P1909 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int[][] arr = new int[3][2];
		for (int i = 0; i < arr.length; i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		int minMoney = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (num % arr[i][0] == 0) {
				minMoney = num / arr[i][0] * arr[i][1] < minMoney ? num / arr[i][0] * arr[i][1] : minMoney;
			} else {
				minMoney = (num / arr[i][0] + 1) * arr[i][1] < minMoney ? (num / arr[i][0] + 1) * arr[i][1] : minMoney;
			}
		}
		System.out.println(minMoney);

	}
}
