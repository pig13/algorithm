package div3_540;
import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class D1 {

	static Scanner scan = new Scanner(new BufferedInputStream(System.in));
	static ArrayList<Integer> list = new ArrayList<>();
	static int n, m;

	public static void main(String[] args) {
		n = scan.nextInt();
		m = scan.nextInt();
		int sum = 0;
		for (int i = 0; i < n; i++) {
			int temp = scan.nextInt();
			sum = sum + temp;
			list.add(temp);
		}
		if (sum < m) {
			System.out.println(-1);
		} else if (sum == m) {
			System.out.println(n);
		} else {
			Collections.sort(list, Collections.reverseOrder());
			for (int i = 1; i < 101; i++) {
				if (fun(i) >= m) {
					System.out.println(i);
					break;
				}
			}
		}
	}

	static int fun(int day) {
		int sum = 0;
		int h=n/day+1;
		int w=day;
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (i * day + j >= list.size()) {
					break;
				}
				int temp = list.get(i * day + j) - i;
				if (temp <= 0) {
					break;
				}
				sum = sum + temp;
			}
		}

		return sum;
	}
}