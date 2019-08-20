package div3_529;

import java.io.BufferedOutputStream;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

public class testC {
	static int[] set = { 1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024, 2048, 4096, 8192, 16384, 32768, 65536, 131072,
			262144, 524288, 1048576, 2097152, 4194304, 8388608, 16777216, 33554432, 67108864, 134217728, 268435456,
			536870912, 1073741824 };

	static Set<Integer> set2;
	static PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));

	static class comparator implements Comparator<Integer> {
		@Override
		public int compare(Integer o1, Integer o2) {
			// TODO Auto-generated method stub
			return o2 - o1;
		}
	}

	public static void main(String[] args) {
//		LinkedList<Integer> list = new LinkedList<Integer>();
		PriorityQueue<Integer> list = new PriorityQueue<Integer>(new comparator());
		set2 = new HashSet<Integer>();
		for (int i = 0; i < set.length; i++) {
			set2.add(set[i]);
		}

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int N = n;
		int k = sc.nextInt();
//		for (; n != 0;) {
//			for (int i = n; i >= 1; i--) {
//				if (func(i)) {
//					n -= i;
//					list.add(i);
//					break;
//				}
//			}
//		}
		int i;
		for (; n != 0;) {
			for (i = 0; set[i] <= n; i++) {
			}
			if (i == 0) {
				n -= set[i];
				list.add(set[i]);
				break;
			}
			n -= set[i - 1];
			list.add(set[i - 1]);

		}

		if (k < list.size() || k > N) {
			System.out.println("NO");
			return;
		}
		int tmp;
		for (; list.size() != k;) {
			tmp = list.poll();
			if (tmp == 1) {
//				list.push(tmp);
				list.add(tmp);

			} else {
				list.add(tmp / 2);
				list.add(tmp / 2);
//				list.push(tmp / 2);
//				list.push(tmp / 2);
			}
		}
		System.out.println("YES");
		for (; list.size() != 0;) {
			if (list.size() == 1) {
//				System.out.print(list.poll());
				pw.print(list.poll());
			} else {
//				System.out.print(list.poll() + " ");
				pw.print(list.poll() + " ");
			}
		}
		pw.flush();

	}

	public static boolean func(int n) {
//		for (int i = 0; i < set.length; i++) {
//			if (set[i] == n) {
//				return true;
//			}
//		}
//		return false;

		if (set2.contains(n)) {
			return true;
		} else {
			return false;
		}

//		if (n == 0) {
//			return false;
//		}
//		for (; n % 2 != 1;) {
//			n /= 2;
//		}
//		if (n == 1) {
//			return true;
//
//		} else {
//			return false;
//		}
	}
}
