package grade1300_1500;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Set;

public class TwoButtons {
	static class Node {
		int count;
		int value;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		Queue<Node> queue = new LinkedList<Node>();
		Set<Integer> set = new HashSet<Integer>();
		Node node;
		node = new Node();
		node.count = 0;
		node.value = n;
		queue.add(node);
		set.add(node.value);
		Node tmp;
		for (; !queue.isEmpty();) {
			tmp = queue.poll();
			if (tmp.value == m) {
				System.out.println(tmp.count);
				return;
			}
			if (tmp.value > 1 && !set.contains(tmp.value - 1)) {
				node = new Node();
				node.count = tmp.count + 1;
				node.value = tmp.value - 1;
				queue.add(node);
				set.add(node.value);
			}
			if (tmp.value < m && !set.contains(tmp.value * 2)) {
				node = new Node();
				node.count = tmp.count + 1;
				node.value = tmp.value * 2;
				queue.add(node);
				set.add(node.value);
			}
		}
	}
}
