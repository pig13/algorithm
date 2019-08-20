package div2_553;

import java.util.Scanner;

public class TaskA {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String sub = sc.next();
		int min = Integer.MAX_VALUE;
		int tmp;

		for (int i = 0; i < sub.length() - 3; i++) {
			tmp = func(sub.substring(i, i + 4));
			min = tmp < min ? tmp : min;
		}
		System.out.println(min);
	}

	public static int func(String sub) {
		char ch1 = sub.charAt(0);
		char ch2 = sub.charAt(1);
		char ch3 = sub.charAt(2);
		char ch4 = sub.charAt(3);
		int count = 0;
		count += Math.abs('A' - ch1) < 26 - Math.abs('A' - ch1) ? Math.abs('A' - ch1) : 26 - Math.abs('A' - ch1);
		count += Math.abs('C' - ch2) < 26 - Math.abs('C' - ch2) ? Math.abs('C' - ch2) : 26 - Math.abs('C' - ch2);
		count += Math.abs('T' - ch3) < 26 - Math.abs('T' - ch3) ? Math.abs('T' - ch3) : 26 - Math.abs('T' - ch3);
		count += Math.abs('G' - ch4) < 26 - Math.abs('G' - ch4) ? Math.abs('G' - ch4) : 26 - Math.abs('G' - ch4);
		return count;

	}

}
