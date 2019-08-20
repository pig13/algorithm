package luogu;

import java.util.Scanner;

public class P1031 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int sum = 0;
		int[] arr = new int[n];
		int tmp;
		for (int i = 0; i < n; i++) {
			tmp = sc.nextInt();
			sum += tmp;
			arr[i] = tmp;
		}
		int mid = sum / n;
		int count = 0;
		int pre = 0;
		for (pre = 0; pre < arr.length; pre++) {
			if (arr[pre] != mid) {
				break;
			}
		}
		if (pre == arr.length) {
			System.out.println(0);
			return;

		}
		boolean flag = false;
		int cur = arr[pre];
		for (int i = pre + 1; i < arr.length; i++) {
			cur += arr[i];
			if ((cur >= mid * (i - pre + 1) && flag == false) || cur >= mid * (i - pre) && flag == true) {
				if (flag) {
					cur -= mid * (i - pre);
				} else {
					cur -= mid * (i - pre + 1);
				}
				if (cur > 0) {
					flag = true;
				} else {
					flag = false;
				}
				count += i - pre;
				if (cur == 0) {
					for (pre = i + 1; pre < arr.length; pre++) {
						if (arr[pre] != mid) {
							break;
						}
					}
					i = pre;
					if (pre < arr.length) {
						cur += arr[pre];
					}
				} else {
					pre = i;
				}

			}

		}
		System.out.println(count);
	}
}
