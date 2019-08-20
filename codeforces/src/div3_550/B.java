package div3_550;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class B {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<Integer> odd = new ArrayList<Integer>();
		ArrayList<Integer> even = new ArrayList<Integer>();
		int tmp;
		for (int i = 0; i < n; i++) {
			tmp = sc.nextInt();
			if (tmp % 2 == 0) {
				even.add(tmp);
			} else {
				odd.add(tmp);
			}
		}
		if (Math.abs(odd.size() - even.size()) <= 1) {
			System.out.println(0);
			return;
		}
		Collections.sort(odd);
		Collections.sort(even);
		ArrayList<Integer> longarr = odd.size() > even.size() ? odd : even;
		ArrayList<Integer> shortarr = odd.size() > even.size() ? even : odd;
		int sum = 0;
		for (int i = 0; i < longarr.size() - shortarr.size() - 1; i++) {
			sum += (int) longarr.get(i);
		}
		System.out.println(sum);

	}
}
