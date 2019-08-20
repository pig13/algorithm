package luogu;

import java.util.Scanner;

public class P1098 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int p1 = sc.nextInt();
		int p2 = sc.nextInt();
		int p3 = sc.nextInt();
		String text = sc.next().trim();
		String[] ss = text.split("-", 1000000000);
		String res = ss[0];
		String tmp;
		String LEttER = "qwertyuiopasdfghjklzxcvbnm";
		String NUM = "7894561230";

		for (int i = 1; i < ss.length; i++) {
			if (ss[i].equals("")) {
				res += "-";
				continue;
			}
			if (ss[i - 1].equals("")) {
				res += "-" + ss[i];
				continue;
			}

			if (ss[i - 1].charAt(ss[i - 1].length() - 1) >= ss[i].charAt(0)) {
				res += "-";
			} else if (ss[i - 1].charAt(ss[i - 1].length() - 1) + 1 == ss[i].charAt(0)) {
			} else {

				String ch1 = new Character(ss[i - 1].charAt(ss[i - 1].length() - 1)).toString();
				String ch2 = new Character(ss[i].charAt(0)).toString();
				if (!((LEttER.contains(ch1) && LEttER.contains(ch2)) || (NUM.contains(ch1) && NUM.contains(ch2)))) {
					res += "-" + ss[i];
					continue;
				}

				tmp = "";
				if (p3 == 1) {
					// 正序
					for (int j = ss[i - 1].charAt(ss[i - 1].length() - 1) + 1; j <= ss[i].charAt(0) - 1; j++) {
						for (int k = 0; k < p2; k++) {
							tmp += new Character((char) j).toString();
						}

					}
				} else {
					// 逆序
					for (int j = ss[i].charAt(0) - 1; j >= ss[i - 1].charAt(ss[i - 1].length() - 1) + 1; j--) {
						for (int k = 0; k < p2; k++) {
							tmp += new Character((char) j).toString();
						}
					}
				}
				if (p1 == 1) {
					tmp = tmp.toLowerCase();
				} else if (p1 == 2) {
					tmp = tmp.toUpperCase();

				} else {
					int n = tmp.length();
					tmp = "";
					for (int j = 0; j < n; j++) {
						tmp += "*";
					}
				}
				res += tmp;
			}
			res += ss[i];
		}
		System.out.println(res);
	}
}
