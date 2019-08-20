package ccpcnetdemo;

import java.util.Scanner;

public class H {

	static Scanner scan = new Scanner(System.in);
	static int[] data = new int[32];

	public static void main(String[] args) {
		int l = scan.nextInt();
		int r = scan.nextInt();
		char[] lchar = Integer.toBinaryString(l).toCharArray();
		char[] rchar = Integer.toBinaryString(r).toCharArray();
		data[0] = 1;
		for (int i = 1; i < data.length; i++) {
			data[i] = data[i-1] * 2;
		}
		if (lchar.length < rchar.length) {
			fun(lchar, rchar);
		} else {
			fun1(lchar, rchar);
		}

	}

	static void fun1(char[] l, char[] r) {
		int lie = 0;
		for (int i = 0; i < r.length; i++) {
			if (l[i] != r[i]) {
				lie = i;
				break;
			}
		}
		for (int i = lie + 1; i < l.length; i++) {
			l[i] = '1';
		}
		System.out.println(Integer.parseInt(new String(l),2));

	}

	static void fun(char[] l, char[] r) {
		int rnum = Integer.parseInt(new String(r),2);
		for (int i = 0; i < l.length; i++) {
			l[i] = '1';
		}
		int num = Integer.parseInt(new String(l),2);
		for (int i = l.length; i < r.length; i++) {
			if (num + data[i] <= rnum) {
				num = num + data[i];
			} else {
				break;
			}
		}
		System.out.println(num);

	}
}
