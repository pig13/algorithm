package grade1300_1500;

import java.util.Arrays;
import java.util.Scanner;

public class CutRibbon {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[3];
		for (int i = 0; i < 3; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		int ans = Integer.MIN_VALUE;
		for (int i = n / arr[0]; i >= 0; i--) {
			for (int j = n / arr[1]; j >= 0; j--) {
				if ((n - i * arr[0] - j * arr[1]) % arr[2] == 0 && (n - i * arr[0] - j * arr[1]) >= 0) {
					int tmp = i + j + (n - i * arr[0] - j * arr[1]) / arr[2];
					ans = tmp > ans ? tmp : ans;
				}
			}
		}
		System.out.println(ans);
	}

}
