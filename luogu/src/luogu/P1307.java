package luogu;

import java.util.Scanner;

public class P1307 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String num = sc.next();
		if (num.trim().equals("0")) {
			System.out.println(0);
			return;
		}
		boolean positive = true;
		if (num.contains("-")) {
			positive = false;
			num = num.substring(1);
		}
		if (!positive) {
			System.out.print("-");
		}

		String res = "";
		for (int i = num.length() - 1; i >= 0; i--) {
			res += num.substring(i, i + 1);
		}

//		System.out.println(res);
		res = new Integer(res).toString();
		System.out.println(res);
	}

}
