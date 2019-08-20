package luogu_str;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P1603 {
	static long min = Long.MAX_VALUE;

	public static void main(String[] args) {
		String[] ss = "one two three four five six seven eight nine ten eleven twelve thirteen fourteen fifteen sixteen seventeen eighteen nineteen twenty"
				.split(" ");
		ArrayList<String> res = new ArrayList<String>();
		Map<String, String> map = new HashMap<String, String>();
		String tmp;
		for (int i = 0; i < ss.length; i++) {
			tmp = "" + ((int) Math.pow(i + 1, 2) % 100);
			if (tmp.length() != 2) {
				tmp = "0" + tmp;
			}
			map.put(ss[i], tmp);
		}
//		a both another first second third
		map.put("a", "01");
		map.put("both", "04");
		map.put("another", "01");
		map.put("first", "01");
		map.put("second", "04");
		map.put("third", "09");

		Scanner sc = new Scanner(System.in);
		for (String sss : sc.nextLine().trim().split(" ")) {
			if (map.containsKey(sss)) {
				res.add(map.get(sss));
			}
		}

		if (res.isEmpty()) {
			System.out.println(0);
			return;
		}

		dfs(res, 0);
		System.out.println(min);
	}

	public static void dfs(ArrayList<String> arr, int index) {
		if (arr == null || index < 0 || index > arr.size()) {
			return;
		}
		if (index == arr.size() - 1) {
			long tmp = Long.parseLong(String.join("", arr));
			min = tmp < min ? tmp : min;
			return;
		}
		for (int i = index; i < arr.size(); i++) {
			String tmp = arr.get(index);
			arr.set(index, arr.get(i));
			arr.set(i, tmp);
			dfs(arr, index + 1);
			tmp = arr.get(index);
			arr.set(index, arr.get(i));
			arr.set(i, tmp);

		}
	}

}
