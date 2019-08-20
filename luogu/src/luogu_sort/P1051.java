package luogu_sort;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class P1051 {
	static class Student {
		int id;
		String name;
		int avgGrade;
		int classGrade;
		String leader;
		String west;
		int paper;
		int schoolShip = 0;

//		public Student(int id, String name, int avgGrade, int classGrade, boolean leader, boolean west, int paper) {
//			this.id = id;
//			this.name = name;
//			this.avgGrade = avgGrade;
//			this.classGrade = classGrade;
//			this.leader = leader;
//			this.west = west;
//			this.paper = paper;
//		}

	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		Student stu;
		ArrayList<Student> list = new ArrayList<Student>();
		for (int i = 0; i < n; i++) {
			stu = new Student();
			list.add(stu);
			stu.id = i;
			stu.name = sc.next();
			stu.avgGrade = sc.nextInt();
			stu.classGrade = sc.nextInt();
			stu.leader = sc.next();
			stu.west = sc.next();
			stu.paper = sc.nextInt();
		}
		for (int i = 0; i < list.size(); i++) {
			func(list.get(i));
		}
		list.sort(new StudentComparator());
		int sum = 0;
		for (int i = 0; i < list.size(); i++) {
			sum += list.get(i).schoolShip;
		}
		System.out.println(list.get(0).name);
		System.out.println(list.get(0).schoolShip);
		System.out.println(sum);

	}

	static class StudentComparator implements Comparator<Student> {
		@Override
		public int compare(Student o1, Student o2) {
			int tmp;
			tmp = o2.schoolShip - o1.schoolShip;
			if (tmp == 0) {
				return o1.id - o2.id;
			}
			return tmp;
		}
	}

	public static void func(Student stu) {
		if (stu.avgGrade > 80 && stu.paper >= 1) {
			stu.schoolShip += 8000;
		}
		if (stu.avgGrade > 85 && stu.classGrade > 80) {
			stu.schoolShip += 4000;
		}
		if (stu.avgGrade > 90) {
			stu.schoolShip += 2000;
		}
		if (stu.avgGrade > 85 && stu.west.equals("Y")) {
			stu.schoolShip += 1000;
		}
		if (stu.classGrade > 80 && stu.leader.equals("Y")) {
			stu.schoolShip += 850;
		}
	}

}
