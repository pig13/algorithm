package luogu;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class P2141 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		LinkedList<Integer> list = new LinkedList<Integer>();
		int tmp;
		for (int i = 0; i < num; i++) {
			tmp = sc.nextInt();
			list.add(tmp);
			map.put(tmp, 0);
		}
		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {
				if (map.containsKey(list.get(i) + list.get(j))) {
					map.put(list.get(i) + list.get(j), map.get(list.get(i) + list.get(j)) + 1);
				}
			}
		}
		int count = 0;
		for (Integer value : map.values()) {
			if (value != 0) {
				count++;
			}
		}
		System.out.println(count);

	}
}
