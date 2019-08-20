package div3_550;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class A {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] arr = new String[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.next();
		}
		char[] tmp;
		int j;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].length() == 1) {
				System.out.println("YES");
			} else if (arr[i].length() > 26) {
				System.out.println("NO");
			} else {
				tmp = arr[i].toCharArray();
				Arrays.sort(tmp);
				for (j = 0; j < tmp.length; j++) {
					if (tmp[0] + j != tmp[j]) {

						System.out.println("NO");
						break;
					}
				}
				if (j == tmp.length) {
					System.out.println("YES");
				}
			}

		}

	}
}
