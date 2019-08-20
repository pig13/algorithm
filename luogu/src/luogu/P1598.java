package luogu;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P1598 {
//	这一题解答用hashmap目前没事，但是hashmap不保证有序，只是在这里正好显示有序
	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<String, Integer>();
		String AAA = "QWERTYUIOPASDFGHJKLZXCVBNM";
		for (int i = 0; i < AAA.length(); i++) {
			map.put(AAA.substring(i, i + 1), 0);
		}

		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 4; i++) {
			String str = sc.nextLine();
			for (int j = 0; j < str.length(); j++) {
				String tmp = str.substring(j, j + 1);
				if (AAA.contains(tmp)) {
					map.put(tmp, map.get(tmp) + 1);
				}
			}
		}
		int MAX = Integer.MIN_VALUE;
		for (String key : map.keySet()) {
			MAX = MAX < map.get(key) ? map.get(key) : MAX;
		}
		int max = MAX;
		int tmp = Integer.MIN_VALUE;
		for (int i = 0; i < MAX; i++) {
			for (int j = 0; j < 26; j++) {
				for (String key : map.keySet()) {
					if (map.get(key) == max) {
						System.out.print("* ");
						map.put(key, map.get(key) - 1);
					} else {
						System.out.print("  ");
					}
					tmp = tmp < map.get(key) ? map.get(key) : tmp;
				}
			}
			max = tmp;
			tmp = Integer.MIN_VALUE;
			System.out.println();
		}
		String str = "";
		for (String key : map.keySet()) {
			str += key + " ";
		}
		System.out.println(str.trim());
	}
}
