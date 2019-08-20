package grade1300_1500;

import java.util.Scanner;

public class GivenLengthandSumofDigits {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int s = sc.nextInt();
		int s2 = s;
		if (m == 1 && s == 0) {
			System.out.println("0 0");
			return;
		}
		if (s < 1 || s > m * 9) {
			System.out.println("-1 -1");
			return;
		}
		int[] arr = new int[m];
		arr[m - 1] = 1;
		s--;
		for (int i = 0; i < arr.length; i++) {
			if (s == 0) {
				break;
			}
			if (s >= 9) {
				arr[i] = 9;
				s -= 9;
			} else {
				arr[i] = arr[i] + s;
				s -= s;
			}
		}
		for (int i = arr.length - 1; i >= 0; i--) {
			System.out.print(arr[i]);
		}
		System.out.print(" ");
		for (int i = 0; i < arr.length; i++) {
			arr[i] = 0;
		}
		for (int i = 0; i < arr.length; i++) {
			if (s2 == 0) {
				break;
			}
			if (s2 >= 9) {
				arr[i] = 9;
				s2 -= 9;
			} else {
				arr[i] = s2;
				s2 -= s2;
			}
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]);
		}

	}
}
