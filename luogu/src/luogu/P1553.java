package luogu;

import java.math.BigInteger;
import java.util.Scanner;

public class P1553 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String num = sc.nextLine();
		String res = "";
		if (num.contains(".")) {
//			处理小数
			String[] tmp = num.split("\\.");
			String pre = func(tmp[0]);
			String bef = func(tmp[1]);
			res = pre + "." + bef;
		} else if (num.contains("/")) {
//			处理分数
			String[] tmp = num.split("/");
			String pre = func(tmp[0]);
			String bef = func(tmp[1]);
			res = pre + "/" + bef;

		} else if (num.contains("%")) {
//			处理百分数
			String[] tmp = num.split("%");
			String pre = func(tmp[0]);
			res = pre + "%";
		} else {
//			处理整数
			res = func(num);
		}
		System.out.println(res);
	}

	public static String func(String num) {
		for (; num.startsWith("0") && num.length() != 1;) {
			num = num.substring(1);
		}

		String res = "";
		for (int i = num.length() - 1; i >= 0; i--) {
			res += num.substring(i, i + 1);
		}
		res = new BigInteger(res).toString();
		return res;
	}

}
