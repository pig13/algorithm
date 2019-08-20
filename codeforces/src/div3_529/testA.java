package div3_529;

import java.util.Scanner;

public class testA {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		String ss = sc.next();
		String res = "";
		int count = 1;
		for (int i = 1; i <= ss.length();) {
			res += ss.substring(i - 1, i);
			i += count;
			count++;
		}
		System.out.println(res);

	}
}
