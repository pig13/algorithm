package luogu;

import java.util.Arrays;
import java.util.Scanner;

public class P1914 {
	static char[] lowwer = new char[26];
	static char[] upper = new char[26];

	public static void main(String[] args) {
		String tmp = "qwertyuiopasdfghjklzxcvbnm";
		lowwer = tmp.toCharArray();
		Arrays.sort(lowwer);
		tmp = tmp.toUpperCase();
		upper = tmp.toCharArray();
		Arrays.sort(upper);

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		String pwd = sc.nextLine();
		String res = "";
		for (int i = 0; i < pwd.length(); i++) {
			res += new Character(func(pwd.charAt(i), n)).toString();
		}
		System.out.println(res);

	}

	public static char func(char ss, int n) {
		if ((int) ss >= 65 && (int) ss <= 90) {
//			大写
			ss = upper[((int) ss - 65 + n) % 26];
		} else {
			ss = lowwer[((int) ss - 97 + n) % 26];
		}
		return ss;

	}

}
