package luogu_str;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P1071 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String key = sc.nextLine().trim();
		String value = sc.nextLine().trim();
		String text = sc.nextLine().trim();
		String res = "";
		Map<String, String> map = new HashMap<String, String>();
		String tmp;
		String tmp2;
		for (int i = 0; i < key.length(); i++) {
			tmp = new Character(key.charAt(i)).toString();
			tmp2 = new Character(value.charAt(i)).toString();
			if (map.containsKey(tmp)) {
				if (!map.get(tmp).equals(tmp2)) {
					System.out.println("Failed");
					return;
				}
			} else {
				if (map.containsValue(tmp2)) {
					System.out.println("Failed");
					return;
				}
				map.put(tmp, tmp2);
			}
		}
		if (map.size() < 26) {
			System.out.println("Failed");
			return;
		}
		for (int i = 0; i < text.length(); i++) {
			tmp = new Character(text.charAt(i)).toString();
			res += map.get(tmp);
		}
		System.out.println(res.toString());

	}
}
