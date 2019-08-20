package luogu;

import java.util.LinkedList;
import java.util.Scanner;

public class P1046 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int i = 0; i < 10; i++) {
			list.add(sc.nextInt());
		}
		int height = sc.nextInt() + 30;
		int count = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i) <= height) {
				count++;
			}
		}
		System.out.println(count);
	}
}
