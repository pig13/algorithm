package div3_498;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class TaskB {
	static class Node {
		int index;
		int value;
	}

	static class ComparatorByValue implements Comparator<Node> {
		@Override
		public int compare(Node o1, Node o2) {
			return o2.value - o1.value;
		}
	}

	static class ComparatorByIndex implements Comparator<Node> {
		@Override
		public int compare(Node o1, Node o2) {
			return o1.index - o2.index;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		List<Node> list = new ArrayList<Node>();
		Node node;
		for (int i = 0; i < n; i++) {
			node = new Node();
			node.index = i + 1;
			node.value = sc.nextInt();
			list.add(node);
		}
		list.sort(new ComparatorByValue());
		list = list.subList(0, k);
		int sum = 0;
		for (int i = 0; i < list.size(); i++) {
			sum += list.get(i).value;
		}
		if (k == 1) {
			System.out.println(sum);
			System.out.println(n);
			return;
		}
		list.sort(new ComparatorByIndex());
		System.out.println(sum);
		int[] arr = new int[k];
		arr[0] = list.get(0).index - 0;
		for (int i = 1; i < arr.length; i++) {
			if (i == arr.length - 1) {
				arr[i] = n - list.get(i - 1).index;
			} else {
				arr[i] = list.get(i).index - list.get(i - 1).index;
			}
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

	}

}
