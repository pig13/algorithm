package luogu;

import java.util.Scanner;

public class P1055 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String isbn = sc.nextLine();
		String str = isbn.replace("-", "");
		Integer right = 0;
		for (int i = 0; i < str.length() - 1; i++) {
			right += Integer.parseInt(str.substring(i, i + 1)) * (i + 1);
		}
		right %= 11;
		String rightStr = right != 10 ? right.toString() : "X";
		if (rightStr.equals(str.substring(str.length() - 1))) {
			System.out.println("Right");
		} else {
			System.out.println(isbn.substring(0, isbn.length() - 1) + rightStr);
		}

	}
}
