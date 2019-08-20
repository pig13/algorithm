package luogu_sort;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class P1781 {
	static class Person {
		int id;
		BigInteger grade;

		public Person(int id, BigInteger grade) {
			this.id = id;
			this.grade = grade;
		}
	}

	static class PersonComparator implements Comparator<Person> {
		@Override
		public int compare(Person o1, Person o2) {
			int tmp = o2.grade.compareTo(o1.grade);
			if (tmp == 0) {
				return o1.id - o2.id;
			}
			return tmp;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Person> list = new ArrayList<Person>();
		for (int i = 1; i <= n; i++) {
			list.add(new Person(i, new BigInteger(sc.next())));
		}
		list.sort(new PersonComparator());
		System.out.println(list.get(0).id);
		System.out.println(list.get(0).grade);

	}

}
