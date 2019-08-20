package luogu_sort;

import java.util.PriorityQueue;

public class test {
	public static void main(String[] args) {
		int[] arr = { 1, 2, 1231, 43, 1, 342, 143 };
		int[] res = topK(arr, 3);
		for (int i = 0; i < res.length; i++) {
			System.out.println(res[i] + " ");
		}
	}

	public static int[] topK(int[] arr, int k) {
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		for (int i : arr) {
			queue.add(i);
			if (queue.size() > k) {
				queue.poll();
			}
		}
		int[] res = new int[k];
		for (int i = k - 1; i >= 0; i--) {
			res[i] = queue.poll();
		}
		return res;
	}
}
