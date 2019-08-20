package grade1300_1500;

import java.util.Scanner;

public class Books {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int t = sc.nextInt();
		int[] arr = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			if (i == 1) {
				arr[i] = sc.nextInt();
			} else {
				arr[i] = arr[i - 1] + sc.nextInt();
			}
		}
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + max + 1; j < arr.length; j++) {
				if (arr[j] - arr[i] > t) {
					break;
				}
				max = j - i > max ? j - i : max;
			}
		}
		System.out.println(max);
	}
}
