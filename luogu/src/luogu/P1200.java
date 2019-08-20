package luogu;

import java.util.Scanner;

public class P1200 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String UFOName = sc.nextLine();
		String groupName = sc.nextLine();
		if (XNum(UFOName) % 47 == XNum(groupName) % 47) {
			System.out.println("GO");
		} else {
			System.out.println("STAY");
		}
	}

	public static int XNum(String str) {
		int res = 1;
		for (int i = 0; i < str.length(); i++) {
			res *= (int) str.charAt(i) - 64;
		}
		return res;

	}
}
