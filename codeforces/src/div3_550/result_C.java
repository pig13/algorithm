package div3_550;
import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class result_C {

	static Scanner scan = new Scanner(new BufferedInputStream(System.in));
	static Map<Integer, Integer> map = new HashMap<>();
	static ArrayList<Integer> increase = new ArrayList<>();
	static ArrayList<Integer> decrese = new ArrayList<>();

	public static void main(String[] args) {
		int n = scan.nextInt();
		for (int i = 0; i < n; i++) {
			int temp = scan.nextInt();
			if (map.containsKey(temp)) {
				map.put(temp, map.get(temp) + 1);
			} else {
				map.put(temp, 1);
			}
		}
		boolean flag = true;
		for (Integer i : map.keySet()) {
			int temp = map.get(i);
			if (temp >= 3) {
				flag = false;
			}
			if (temp == 2) {
				increase.add(i);
			}
			decrese.add(i);
		}
		if (!flag) {
			System.out.println("NO");
		} else {
			Collections.sort(increase);
			Collections.sort(decrese, Collections.reverseOrder());
			System.out.println("YES");
			System.out.println(increase.size());
			for (int i = 0; i < increase.size(); i++) {
				System.out.print(increase.get(i)+" ");
			}
			System.out.println();
			System.out.println(decrese.size());
			for (int i = 0; i < decrese.size(); i++) {
				System.out.print(decrese.get(i)+" ");
			}
			System.out.println();
		}
	}
}
