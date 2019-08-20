package luogu_sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class P1093 {

	static class Student {
		int id;
		int chinese;
		int math;
		int english;
		int sum;
	}

	static class StudentComparator implements Comparator<Student> {
		@Override
		public int compare(Student o1, Student o2) {
			int tmp = o2.sum - o1.sum;
			if (tmp == 0) {
				tmp = o2.chinese - o1.chinese;
				if (tmp == 0) {
					return o1.id - o2.id;
				}
				return tmp;
			}
			return tmp;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Student stu;
		ArrayList<Student> list = new ArrayList<Student>();
		for (int i = 1; i <= n; i++) {
			stu = new Student();
			list.add(stu);
			stu.id = i;
			stu.chinese = sc.nextInt();
			stu.math = sc.nextInt();
			stu.english = sc.nextInt();
			stu.sum = stu.chinese + stu.math + stu.english;
		}
		list.sort(new StudentComparator());
		if (list.size() < 5) {
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i).id + " " + list.get(i).sum);
			}
			return;
		}
		for (int i = 0; i < 5; i++) {
			System.out.println(list.get(i).id + " " + list.get(i).sum);
		}

	}

}
