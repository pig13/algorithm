package luogu;

import java.util.Scanner;

public class P1085 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] week = new int[7][2];
		for (int i = 0; i < week.length; i++) {
			week[i][0] = sc.nextInt();
			week[i][1] = sc.nextInt();
		}
		int maxHourse = 0;
		int maxDay = 0;
		for (int i = 0; i < week.length; i++) {
			if (week[i][0] + week[i][1] > maxHourse) {
				maxHourse = week[i][0] + week[i][1];
				maxDay = i + 1;
			}
		}
		System.out.println(maxDay);

	}
}
