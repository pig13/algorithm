package div3_529;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class testB {

	static class comparator implements Comparator<Integer> {
		@Override
		public int compare(Integer o1, Integer o2) {
			// TODO Auto-generated method stub
			return o1 - o2;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int i = 0; i < num; i++) {
			list.add(sc.nextInt());
		}
		list.sort(new comparator());
		if (list.size() == 1 || list.size() == 2) {
			System.out.println(0);
			return;
		}
		if (list.size() == 3) {
			int a = list.get(0);
			int b = list.get(1);
			int c = list.get(2);
			int min = b - a > c - b ? c - b : b - a;
			System.out.println(min);
			return;
		}
		int a = list.get(0);
		int b = list.get(1);
		int c = list.get(list.size() - 2);
		int d = list.get(list.size() - 1);
		int min = c - a > d - b ? d - b : c - a;
		System.out.println(min);
	}
}
