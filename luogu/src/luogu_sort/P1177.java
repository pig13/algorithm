package luogu_sort;

import java.util.Scanner;

public class P1177 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		quickSort(arr);
		for (int i = 0; i < arr.length; i++) {
			if (i != arr.length - 1) {
				System.out.print(arr[i] + " ");
			} else {
				System.out.println(arr[i]);
			}

		}

	}

	public static void quickSort(int[] arr) {
		if (arr == null || arr.length < 2) {
			return;
		}
		quickSort(arr, 0, arr.length - 1);
	}

	public static void quickSort(int[] arr, int l, int r) {
		if (l < r) {
			swap(arr, r, l + (int) (Math.random() * (r - l + 1)));
			int[] p = partition(arr, l, r);
			quickSort(arr, l, p[0] - 1);
			quickSort(arr, p[1] + 1, r);

		}
	}

	public static int[] partition(int[] arr, int l, int r) {
		int less = l - 1;
		int more = r;
		for (int i = l; i < more; i++) {
			if (arr[i] < arr[r]) {
				swap(arr, ++less, i);

			} else if (arr[i] > arr[r]) {
				swap(arr, i, --more);
				i--;
			}
		}
		swap(arr, r, more);
		return new int[] { less + 1, more };

	}

	public static void swap(int[] arr, int l, int r) {
		int tmp = arr[l];
		arr[l] = arr[r];
		arr[r] = tmp;

	}

}
