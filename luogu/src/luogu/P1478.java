package luogu;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class P1478 {
	static class Apple {
		public int height;
		public int power;

		public Apple(int heght, int power) {
			// TODO Auto-generated constructor stub
			this.height = heght;
			this.power = power;
		}
	}

	static class AppleComparator implements Comparator<Apple> {
		@Override
		public int compare(Apple o1, Apple o2) {
			return o1.power - o2.power;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PriorityQueue<Apple> pQ = new PriorityQueue<Apple>(new AppleComparator());
		int n = sc.nextInt();
		int s = sc.nextInt();
		if (n == 0) {
			System.out.println(0);
			return;
		}

		int height = sc.nextInt() + sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < n; i++) {
			pQ.add(new Apple(sc.nextInt(), sc.nextInt()));
		}

		int count = 0;
		for (; pQ.size() != 0 && pQ.peek().power <= s;) {
			if (pQ.peek().height <= height) {
				count++;
				s -= pQ.poll().power;
			} else {
				pQ.poll();
			}
		}
		System.out.println(count);
	}

}
