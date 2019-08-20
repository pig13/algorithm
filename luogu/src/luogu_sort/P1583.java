package luogu_sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class P1583 {

	static int k;
	static ArrayList<Person> list;

	static class Person {
		int id;
		int w;

		public Person(int id, int w) {
			this.id = id;
			this.w = w;
		}
	}

	static class PersonComparator implements Comparator<Person> {
		@Override
		public int compare(Person o1, Person o2) {
			int tmp = o2.w - o1.w;
			if (tmp == 0) {
				return o1.id - o2.id;
			}
			return tmp;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		k = sc.nextInt();
		list = new ArrayList<Person>();
		ArrayList<Integer> l2 = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++) {
			l2.add(sc.nextInt());
		}
		for (int i = 1; i <= n; i++) {
			list.add(new Person(i, sc.nextInt()));
		}
		list.sort(new PersonComparator());
		for (int i = 0; i < list.size(); i++) {
			list.get(i).w += l2.get(i % 10);
		}
		list.sort(new PersonComparator());
		for (int i = 0; i < k; i++) {
			System.out.print(list.get(i).id + " ");
		}
	}

}
