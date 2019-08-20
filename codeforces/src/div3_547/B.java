package div3_547;

import java.util.Scanner;

public class B {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[2 * n];
		int tmp;
		for (int i = 0; i < n; i++) {
			tmp = sc.nextInt();
			arr[i] = tmp;
			arr[n + i] = tmp;
		}
		int max = Integer.MIN_VALUE;
		int cur = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 1) {
				cur++;
			} else {
				max = cur > max ? cur : max;
				cur = 0;
			}

		}
		max = cur > max ? cur : max;
		System.out.println(max);

	}
}
