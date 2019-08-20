package div3_529;

import java.util.LinkedList;

public class test {
	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int i = 1; i < 1000000000; i *= 2) {
			list.add(i);
		}
		System.out.println(list);
	}

	public static boolean func(int n) {
		if (n == 0) {
			return false;
		}
		for (; n % 2 != 1;) {
			n /= 2;
		}
		if (n == 1) {
			return true;

		} else {
			return false;
		}
	}

}
