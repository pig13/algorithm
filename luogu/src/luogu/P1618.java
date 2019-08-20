package luogu;

import java.util.Scanner;

public class P1618 {
	public static void main(String[] args) {
		boolean flag = false;
		Scanner sc = new Scanner(System.in);
		float a = sc.nextFloat();
		float b = sc.nextFloat();
		float c = sc.nextFloat();
		for (int i = 100; i < 999; i++) {
			if (func((int) i, (int) Math.ceil((b / a * i)), (int) Math.ceil((c / a * i)))) {
				System.out.println((int) i + " " + (int) Math.ceil((b / a * i)) + " " + (int) Math.ceil((c / a * i)));
				flag = true;
			}
		}
		if (!flag) {
			System.out.println("No!!!");
		}

	}

	public static boolean func(int a, int b, int c) {
		String str = a + "" + b + "" + c;
		if (str.length() == 9 && str.contains("1") && str.contains("2") && str.contains("3") && str.contains("4")
				&& str.contains("5") && str.contains("6") && str.contains("7") && str.contains("8") && str.contains("9")
				&& !str.contains("0")) {
//			System.out.println(str + "\t" + str.length());
			return true;
		}

		return false;
	}

}
