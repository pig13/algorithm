package div3_550;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class D {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int[] arr = new int[n];
		int tmp;
		for (int i = 0; i < arr.length; i++) {
			tmp = sc.nextInt();
			arr[i] = tmp;
			if (map.containsKey(tmp)) {
				map.put(tmp, map.get(tmp) + 1);
			} else {
				map.put(tmp, 1);
			}
		}
		int maxkey = 0;
		int maxValue = Integer.MIN_VALUE;
		for (int i : map.keySet()) {
			if (map.get(i) > maxValue) {
				maxkey = i;
				maxValue = map.get(i);
			}
		}
		int index = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == maxkey) {
				index = i;
				break;
			}
		}
		System.out.println(arr.length - maxValue);
		for (int i = index - 1; i >= 0; i--) {
			if (arr[i] > maxkey) {
				System.out.println(2 + " " + (i + 1) + " " + (i + 1 + 1));
			} else {
				System.out.println(1 + " " + (i + 1) + " " + (i + 1 + 1));
			}
		}
		for (int i = index + 1; i < arr.length; i++) {
			if (arr[i] == maxkey) {
				continue;
			}
			if (arr[i] > maxkey) {
				System.out.println(2 + " " + (i + 1) + " " + (i - 1 + 1));
			} else {
				System.out.println(1 + " " + (i + 1) + " " + (i - 1 + 1));

			}

		}
	}
}
