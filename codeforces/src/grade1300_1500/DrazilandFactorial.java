package grade1300_1500;

import java.util.Arrays;
import java.util.Scanner;

public class DrazilandFactorial {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		sc.next();
		String ss = sc.next();
		String[] arr = { "", "", "2", "3", "322", "5", "53", "7", "7222", "7332" };
		int tmp;
		String tt = "";
		for (int i = 0; i < ss.length(); i++) {
			tmp = new Integer(ss.substring(i, i + 1));
			if (tmp >= 2 && tmp <= 9) {
				tt += arr[tmp];
			}
		}

		char[] arr2 = tt.toCharArray();
		Arrays.sort(arr2);
		for (int i = arr2.length - 1; i >= 0; i--) {
			System.out.print(arr2[i]);
		}

	}
}
