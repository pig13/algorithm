package luogu;

import java.util.LinkedList;
import java.util.Scanner;

public class P1022 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String formula = sc.next();
		String leftF = formula.split("=")[0];
		String rightF = formula.split("=")[1];
		boolean leftPositive = true;
		boolean rightPositive = true;
		if (leftF.startsWith("-")) {
			leftF = leftF.substring(1);
			leftPositive = false;
		}
		if (rightF.startsWith("-")) {
			rightF = rightF.substring(1);
			rightPositive = false;
		}
		LinkedList<String> list = new LinkedList<String>();

		String[] ss = leftF.split("-");
		if (!leftPositive) {
			ss[0] = "-" + ss[0];
		}
		for (int i = 1; i < ss.length; i++) {
			ss[i] = "-" + ss[i];
		}
		String[] tmp;
		for (int i = 0; i < ss.length; i++) {
			tmp = ss[i].split("\\+");
			for (int j = 0; j < tmp.length; j++) {
				list.add(tmp[j]);
			}
		}

		ss = rightF.split("-");
		if (!rightPositive) {
			ss[0] = "-" + ss[0];
		}
		for (int i = 1; i < ss.length; i++) {
			ss[i] = "-" + ss[i];
		}
		for (int i = 0; i < ss.length; i++) {
			tmp = ss[i].split("\\+");
			for (int j = 0; j < tmp.length; j++) {
				list.add(changeSymbol(tmp[j]));
			}
		}
		String constant = "0";
		String X = "0";
		String tmp2;
		String XXX = "";
		for (; list.size() != 0;) {
			tmp2 = list.poll();
			if (containsX(tmp2)) {
				if (tmp2.length() == 1) {
					X = calcTwoString(X, "1");
					XXX = tmp2;
				} else {
					if (tmp2.length() == 2 && tmp2.contains("-")) {
						X = calcTwoString(X, "-1");
						XXX = tmp2.substring(1);

					} else {

						X = calcTwoString(X, tmp2.substring(0, tmp2.length() - 1));
						XXX = tmp2.substring(tmp2.length() - 1);
					}
				}
			} else {
				constant = calcTwoString(constant, tmp2);
			}
		}
		constant = changeSymbol(constant);
		float res = new Float(constant) / new Float(X);
		res = res == 0 ? 0 : res;
		System.out.println(String.format("%s=%.3f", XXX, res));
	}

	static public String calcTwoString(String s1, String s2) {
		Float res;
		res = new Float(s1) + new Float(s2);
		return res.toString();
	}

	static public boolean containsX(String s) {
		if (s.matches(".*[a-z]{1}")) {
			return true;
		} else {
			return false;
		}
	}

	static public String changeSymbol(String ss) {
//		负变正，正变负,0不变
//		if (new Float(ss) == 0) {
//			return ss;
//		}
		if (ss.matches("0\\.0+")) {
			return ss;
		}
		if (ss.startsWith("-")) {
			return ss.substring(1);
		} else {
			return "-" + ss;
		}
	}

}
