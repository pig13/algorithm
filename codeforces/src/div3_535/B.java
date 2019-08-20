package div3_535;

import java.util.ArrayList;
import java.util.Scanner;

public class B {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		ArrayList<Integer> list = new ArrayList<Integer>();
		int maxX = Integer.MIN_VALUE;
		int tmp;
		for (int i = 0; i < num; i++) {
			tmp = sc.nextInt();
			maxX = tmp > maxX ? tmp : maxX;
			list.add(tmp);
		}
		for (int i = 1; i <= maxX; i++) {
			if (maxX % i == 0) {
				list.remove(new Integer(i));
			}
		}
		int maxY = Integer.MIN_VALUE;
		for (int i = 0; i < list.size(); i++) {
			maxY = list.get(i) > maxY ? list.get(i) : maxY;
		}
		System.out.println(maxX + " " + maxY);
	}
}
