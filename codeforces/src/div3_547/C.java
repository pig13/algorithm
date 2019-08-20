package div3_547;

import java.util.Arrays;
import java.util.Scanner;

public class C {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		arr[0] = 1;
		for (int i = 1; i < n; i++) {
			arr[i] = arr[i - 1] + sc.nextInt();
		}
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < min) {
				min = arr[i];
			}
		}
		for (int i = 0; i < arr.length; i++) {
			arr[i] += (1 - min);
		}
		int[] arr2 = arr.clone();
		Arrays.sort(arr2);
		for (int i = 0; i < arr2.length; i++) {
			if (arr2[i] != arr2[0] + i) {
				System.out.println(-1);
				return;
			}
		}
		for (int i = 0; i < arr.length; i++) {
			if (i != arr.length - 1) {
				System.out.print(arr[i] + " ");
			} else {
				System.out.println(arr[i]);
			}

		}
	}
}
