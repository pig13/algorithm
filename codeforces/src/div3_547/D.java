package div3_547;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class D {

	static class Node {
		int times;
		ArrayList<Integer> index;

		public Node(int times, ArrayList<Integer> index) {
			this.times = times;
			this.index = index;
		}
	}

	static String letf;
	static String right;
	static Map<String, Node> letfMap;
	static Map<String, Node> rightMap;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		letf = sc.next();
		right = sc.next();
		letfMap = new HashMap<String, Node>();
		rightMap = new HashMap<String, Node>();
		ArrayList<Integer> leftData = new ArrayList<Integer>();
		ArrayList<Integer> rightData = new ArrayList<Integer>();

		String tmp;
		ArrayList<Integer> tmp2;
		for (int i = 0; i < n; i++) {
			tmp = letf.substring(i, i + 1);
			if (letfMap.containsKey(tmp)) {
				letfMap.get(tmp).index.add(i);
				letfMap.get(tmp).times++;
			} else {
				tmp2 = new ArrayList<Integer>();
				tmp2.add(i);
				letfMap.put(tmp, new Node(1, tmp2));
			}
		}

		for (int i = 0; i < n; i++) {
			tmp = right.substring(i, i + 1);
			if (rightMap.containsKey(tmp)) {
				rightMap.get(tmp).index.add(i);
				rightMap.get(tmp).times++;
			} else {
				tmp2 = new ArrayList<Integer>();
				tmp2.add(i);
				rightMap.put(tmp, new Node(1, tmp2));
			}
		}
		int count = 0;
		int cur = 0;
		int min;
		for (String key : letfMap.keySet()) {
			if (!key.equals("?")) {
				if (rightMap.containsKey(key)) {
					if (letfMap.get(key).times > rightMap.get(key).times) {
						min = rightMap.get(key).times;
					} else {
						min = letfMap.get(key).times;
					}
					for (int i = 0; i < min; i++) {
						leftData.add(letfMap.get(key).index.get(i) + 1);
						rightData.add(rightMap.get(key).index.get(i) + 1);
					}
					count += min;
					letfMap.get(key).times -= min;
					rightMap.get(key).times -= min;
				}
			}
		}
		for (String key : rightMap.keySet()) {
			if (!letfMap.containsKey("?") || letfMap.get("?").times == 0) {
				break;
			}
			if (!key.equals("?") && rightMap.get(key).times != 0) {
				if (letfMap.get("?").times > rightMap.get(key).times) {
					min = rightMap.get(key).times;
				} else {
					min = letfMap.get("?").times;
				}
				for (int i = letfMap.get("?").index.size() - letfMap.get("?").times; i < min
						+ letfMap.get("?").index.size() - letfMap.get("?").times; i++) {
					leftData.add(letfMap.get("?").index.get(i) + 1);
				}
				for (int i = rightMap.get(key).index.size() - rightMap.get(key).times; i < min
						+ rightMap.get(key).index.size() - rightMap.get(key).times; i++) {
					rightData.add(rightMap.get(key).index.get(i) + 1);
				}
				letfMap.get("?").times -= min;
				rightMap.get(key).times -= min;
				count += min;
			}
		}
		Map<String, Node> tmp3;
		tmp3 = letfMap;
		letfMap = rightMap;
		rightMap = tmp3;

		for (String key : rightMap.keySet()) {
			if (!letfMap.containsKey("?") || letfMap.get("?").times == 0) {
				break;
			}
			if (!key.equals("?") && rightMap.get(key).times != 0) {
				if (letfMap.get("?").times > rightMap.get(key).times) {
					min = rightMap.get(key).times;
				} else {
					min = letfMap.get("?").times;
				}
				for (int i = letfMap.get("?").index.size() - letfMap.get("?").times; i < min
						+ letfMap.get("?").index.size() - letfMap.get("?").times; i++) {
					rightData.add(letfMap.get("?").index.get(i) + 1);
				}
				for (int i = rightMap.get(key).index.size() - rightMap.get(key).times; i < min
						+ rightMap.get(key).index.size() - rightMap.get(key).times; i++) {
					leftData.add(rightMap.get(key).index.get(i) + 1);
				}
				letfMap.get("?").times -= min;
				rightMap.get(key).times -= min;
				count += min;
			}
		}
		tmp3 = letfMap;
		letfMap = rightMap;
		rightMap = tmp3;
		if (letfMap.containsKey("?") && rightMap.containsKey("?") && letfMap.get("?").times != 0
				&& rightMap.get("?").times != 0) {
			if (letfMap.get("?").times > rightMap.get("?").times) {
				min = rightMap.get("?").times;
			} else {
				min = letfMap.get("?").times;
			}
			for (int i = letfMap.get("?").index.size() - letfMap.get("?").times; i < min + letfMap.get("?").index.size()
					- letfMap.get("?").times; i++) {
				leftData.add(letfMap.get("?").index.get(i) + 1);
			}
			for (int i = rightMap.get("?").index.size() - rightMap.get("?").times; i < min
					+ rightMap.get("?").index.size() - rightMap.get("?").times; i++) {
				rightData.add(rightMap.get("?").index.get(i) + 1);
			}
			count += min;
		}
		System.out.println(count);
		for (int i = 0; i < leftData.size(); i++) {
			System.out.println(leftData.get(i) + " " + rightData.get(i));
		}

	}

}
