package div3_550;
import java.io.BufferedInputStream;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class result_B {

	static Scanner scan = new Scanner(new BufferedInputStream(System.in));
	static LinkedList<Integer> odd = new LinkedList<>();
	static LinkedList<Integer> even = new LinkedList<>();
	static long sum = 0;

	static void fun(LinkedList<Integer> list, int len) {
		len = len - 1;
		for (int i = 0; i < len; i++) {
			sum = sum + list.removeFirst();
		}
	}

	public static void main(String[] args) {
		int n = scan.nextInt();
		for (int i = 0; i < n; i++) {
			int temp = scan.nextInt();
			if (temp % 2 == 0)
				odd.add(temp);
			else
				even.add(temp);
		}
		int len = Math.abs(odd.size() - even.size());
		if (len <= 1)
			System.out.println(0);
		else {
			if (odd.size() > even.size()) {
				Collections.sort(odd);
				fun(odd, len);
			} else {
				Collections.sort(even);
				fun(even, len);
			}
			System.out.println(sum);
		}

	}
}
