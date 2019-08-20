package div3_531;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TaskB {

	static class Node {
		ArrayList<Integer> index = new ArrayList<Integer>();
		int time = 0;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		Map<Integer, Node> map = new HashMap<Integer, Node>();
		if (n < k) {
			System.out.println("NO");
			return;
		}
		int[] arr = new int[n];
		int tmp;
		Node node;
		for (int i = 0; i < n; i++) {
			tmp = sc.nextInt();
			arr[i] = tmp;
			if (map.containsKey(tmp)) {
				map.get(tmp).time++;
				map.get(tmp).index.add(i);
			} else {
				node = new Node();
				node.time = 1;
				node.index.add(i);
				map.put(tmp, node);
			}
		}
		int max = Integer.MIN_VALUE;
		for (Integer key : map.keySet()) {
			max = map.get(key).time > max ? map.get(key).time : max;
		}
		if (max > k) {
			System.out.println("NO");
			return;
		}
		int cur = 0;
		int color = 1;
		for (Map.Entry<Integer, Node> entry : map.entrySet()) {
			for (int i : entry.getValue().index) {
				arr[i] = color;
				color = color == k ? 1 : color + 1;
			}
		}
		System.out.println("YES");
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");

		}

	}
}
