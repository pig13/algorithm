package div3_490;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class TaskB {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		LinkedList<Character> list = new LinkedList<Character>();
		LinkedList<Character> tmp = new LinkedList<Character>();
		String ss = sc.next();
		for (int i = 0; i < ss.length(); i++) {
			list.add(ss.charAt(i));
		}
		ArrayList<Integer> ll = new ArrayList<Integer>();
		for (int i = 2; i <= n; i++) {
			if (n % i == 0) {
				ll.add(i);
			}
		}
		for (int i = 0; i < ll.size(); i++) {
			for (int j = 0; j < ll.get(i); j++) {
				tmp.addFirst((list.removeFirst()));
			}
			tmp.addAll(list);
			list = tmp;
//			TODO 有沒有更好把一个对象标记为空
			tmp = new LinkedList<Character>();
		}
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i));
		}

	}
}
