package div3_540;
import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class D2 {

	static Scanner scan = new Scanner(new BufferedInputStream(System.in));
	static ArrayList<Integer> list = new ArrayList<>();
	static long n, m;

	public static void main(String[] args) {
		n = scan.nextInt();
		m = scan.nextInt();
		long sum = 0;
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
			System.out.println(binarySearch(1, 1000000000));
		}
	}

	static int binarySearch(int low, int high) {
		int ans = -1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (check(mid)) {
				ans = mid;
				high = mid - 1;
			} else
				low = mid + 1;
		}
		return ans;
	}

	static boolean check(int mid) {
		// ����true�������������,����false�������ұ�����
		return fun(mid) >= m;
	}

	static long fun(int day) {
		long sum = 0;
		long h = n / day + 1;
		long w = day;
		for (int i = 0; i < h; i++) {
			for (int j = 0; j < w; j++) {
				if (i * day + j >= list.size()) {
					break;
				}
				long temp = list.get(i * day + j) - i;
				if (temp <= 0) {
					break;
				}
				sum = sum + temp;
			}
		}

		return sum;
	}
}