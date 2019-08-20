package div3_550;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class C {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		ArrayList<Integer> increasingarr = new ArrayList<Integer>();
		ArrayList<Integer> decreasingarr = new ArrayList<Integer>();
		for (int i = 0; i < arr.length; i++) {
			if (increasingarr.isEmpty() || increasingarr.get(increasingarr.size() - 1) != arr[i]) {
				increasingarr.add(arr[i]);
			} else {
				decreasingarr.add(arr[i]);
			}
		}
		for (int i = 0; i < decreasingarr.size() - 1; i++) {
			if ((int) decreasingarr.get(i) == decreasingarr.get(i + 1)) {
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
		System.out.println(increasingarr.size());
		if (increasingarr.isEmpty()) {
			System.out.println();
		}
		for (int i = 0; i < increasingarr.size(); i++) {
			if (i != increasingarr.size() - 1) {
				System.out.print(increasingarr.get(i) + " ");
			} else {
				System.out.println(increasingarr.get(i));
			}
		}
		System.out.println(decreasingarr.size());
		if (decreasingarr.isEmpty()) {
			System.out.println();
		}
		for (int i = decreasingarr.size() - 1; i >= 0; i--) {
			if (i != 0) {
				System.out.print(decreasingarr.get(i) + " ");
			} else {
				System.out.println(decreasingarr.get(i));
			}
		}

	}
}
