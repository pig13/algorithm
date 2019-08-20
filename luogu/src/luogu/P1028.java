package luogu;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P1028 {
	static Map<Integer, Integer> map = new HashMap<Integer, Integer>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println(func(sc.nextInt()));
	}

	public static int func(int num) {
		if (num == 1) {
			return 1;
		}
		int res = 1;
		int tmp;
		for (int i = 1; i <= num / 2; i++) {
			if (map.containsKey(i)) {
				res += map.get(i);
			} else {
				tmp = func(i);
				res += tmp;
				map.put(i, tmp);
			}
		}
		return res;

	}

}
