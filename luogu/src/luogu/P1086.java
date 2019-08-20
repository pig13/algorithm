package luogu;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class P1086 {
	static class Node {
		int row;
		int col;
		int n;

		@Override
		public String toString() {
			return row + " " + col + " " + n;
		}
	}

	static class NodeComparator implements Comparator<Node> {
		@Override
		public int compare(Node o1, Node o2) {
			int tmp = o2.n - o1.n;
			if (tmp == 0) {

			}
			return tmp;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int k = sc.nextInt();
		Node node;
		Queue<Node> queue = new PriorityQueue<Node>(new NodeComparator());
		int tmp;
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				tmp = sc.nextInt();
				node = new Node();
				node.row = i;
				node.col = j;
				node.n = tmp;
				queue.add(node);
			}
		}
		k -= 2; // 回去
		if ((queue.peek().row - 1) * 2 + 1 > k) {
			System.out.println(0);
			return;
		}
		int sum = queue.peek().n;
		int row = queue.peek().row;
		int col = queue.peek().col;
		k -= queue.peek().row - 1 + 1;
		queue.poll();
		if (queue.isEmpty() || queue.peek().n == 0) {
			System.out.println(sum);
			return;
		}

		for (; k >= 1 + Math.abs(queue.peek().row - row) + Math.abs(queue.peek().col - col) + queue.peek().row - 1;) {
//			System.out.println(row + " " + col + " " + k + " " + sum);
			k -= Math.abs(queue.peek().row - row) + Math.abs(queue.peek().col - col) + 1;
			sum += queue.peek().n;
			row = queue.peek().row;
			col = queue.peek().col;
			queue.poll();
			if (queue.isEmpty() || queue.peek().n == 0) {
				break;
			}
		}
		System.out.println(sum);
	}
}
