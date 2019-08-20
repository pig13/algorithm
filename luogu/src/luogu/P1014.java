package luogu;

import java.util.Scanner;

public class P1014 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int count = 0;
		int n = 0; // n个斜线
		for (; count < num;) {
			count += n + 1;
			n++;
		}
		boolean UP = true;
		int col;
		int row;
		if (n % 2 == 1) {
			UP = false;
			row = 1;
			col = n;
		} else {
			UP = true;
			row = n;
			col = 1;
		}
		for (; count != num;) {
			if (UP) {
				row--;
				col++;
			} else {
				row++;
				col--;
			}
			count--;
		}
		System.out.println(row + "/" + col);

	}
}
