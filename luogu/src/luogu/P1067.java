package luogu;

import java.util.Scanner;

public class P1067 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		String res = "";
		int tmp;
		for (int i = n; i >= 0; i--) {
			tmp = sc.nextInt();
			if (i == 0) {
				if (tmp == 0) {
					break;
				}
				if (tmp > 0) {
					res += "+" + tmp;
				} else {
					res += tmp;
				}
				break;
			}
			if (i == 1) {
				if (tmp != 0) {
					if (tmp == 1) {
						res += "+x";
					} else if (tmp == -1) {
						res += "-x";
					} else if (tmp > 0) {
						res += "+" + tmp + "x";
					} else {
						res += tmp + "x";
					}
				}
				continue;
			}

			if (tmp != 0) {
				if (tmp == 1) {
					res += "+x^" + i;
				} else if (tmp == -1) {
					res += "-x^" + i;
				} else if (tmp > 0) {
					res += "+" + tmp + "x^" + i;
				} else {
					res += tmp + "x^" + i;
				}
			}
		}
		if (res.startsWith("+")) {
			res = res.substring(1);
		}
		System.out.println(res);

	}

}
