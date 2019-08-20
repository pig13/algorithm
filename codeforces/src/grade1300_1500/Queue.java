package grade1300_1500;

import java.util.PriorityQueue;
import java.util.Scanner;

public class Queue {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for (int i = 0; i < n; i++) {
			pq.add(sc.nextInt());
		}
		int cur = 0;
		int count = 0;
		int tmp;
		for (; !pq.isEmpty();) {
			tmp = pq.poll();
			if (tmp >= cur) {
				cur += tmp;
				count++;
			}
		}
		System.out.println(count);

	}
}
