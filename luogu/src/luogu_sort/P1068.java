package luogu_sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class P1068 {

	static class Person {
		int id;
		int grade;

		public Person(int id, int grade) {
			this.id = id;
			this.grade = grade;
		}
	}

	public static class PersonComprator implements Comparator<Person> {
		@Override
		public int compare(Person o1, Person o2) {
			int tmp = o2.grade - o1.grade;
			if (tmp == 0) {
				return o1.id - o2.id;
			}
			return tmp;
		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		ArrayList<Person> list = new ArrayList<Person>();
		for (int i = 0; i < n; i++) {
			list.add(new Person(sc.nextInt(), sc.nextInt()));
		}
		list.sort(new PersonComprator());
		m = (int) Math.floor(m * 1.5);
		int grade = list.get(m - 1).grade;
		for (; list.get(m).grade == grade; m++) {

		}
		System.out.println(grade + " " + m);
		for (int i = 0; i < m; i++) {
			System.out.println(list.get(i).id + " " + list.get(i).grade);
		}

	}
}
