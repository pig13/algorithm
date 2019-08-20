package div3_535;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class C {
//	写了一个多小时，估计算法是错的。。。。
	static int count = 0;
	static String RGB = "RBG";

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> list = new ArrayList<String>();
		int n = sc.nextInt();
		if (n == 1) {
//			  判断特例  1   2  
			System.out.println(0);
			System.out.println(sc.nextLine());
		} else if (n == 2) {
			String sss = sc.nextLine();
			HashSet<String> set = new HashSet<String>();
			set.add(sss.substring(0, 1));
			set.add(sss.substring(1, 2));
			if (set.size() == 2) {
				System.out.println(0);
				System.out.println(sss);
			} else {
				System.out.println(1);
				for (int i = 0; i < RGB.length(); i++) {
					if (!set.contains(RGB.substring(i, i + 1))) {
						System.out.println(RGB.substring(i, i + 1) + (String) set.toArray()[0]);
						return;
					}
				}
			}

		}
		sc.nextLine();
		String ss = sc.nextLine();
		for (int i = 0; i < ss.length(); i++) {
			list.add(ss.substring(i, i + 1));
		}
		int maxR = Integer.MIN_VALUE;
		int maxG = Integer.MIN_VALUE;
		int maxB = Integer.MIN_VALUE;
		int max = Integer.MIN_VALUE;
		maxR = func(list, "R") > maxR ? func(list, "R") : maxR;
		maxG = func(list, "G") > maxG ? func(list, "G") : maxG;
		maxB = func(list, "B") > maxB ? func(list, "B") : maxB;
		max = max < maxR ? maxR : max;
		max = max < maxG ? maxG : max;
		max = max < maxB ? maxB : max;
		if (max == maxG) {
			initColor(list, "G");

			maxR = Integer.MIN_VALUE;
			maxB = Integer.MIN_VALUE;
			max = Integer.MIN_VALUE;
			maxR = func(list, "R") > maxR ? func(list, "R") : maxR;
			maxB = func(list, "B") > maxB ? func(list, "B") : maxB;
			max = max < maxR ? maxR : max;
			max = max < maxB ? maxB : max;
			if (max == maxR) {
				initColor(list, "R");
				initColor(list, "B");

			} else {
				initColor(list, "B");
				initColor(list, "R");
			}
		} else if (max == maxR) {
			initColor(list, "R");

			maxG = Integer.MIN_VALUE;
			maxB = Integer.MIN_VALUE;
			max = Integer.MIN_VALUE;
			maxG = func(list, "R") > maxG ? func(list, "R") : maxG;
			maxB = func(list, "B") > maxB ? func(list, "B") : maxB;
			max = max < maxG ? maxG : max;
			max = max < maxB ? maxB : max;
			if (max == maxG) {
				initColor(list, "G");
				initColor(list, "B");

			} else {
				initColor(list, "B");
				initColor(list, "G");
			}

		} else if (max == maxB) {
			initColor(list, "B");

			maxG = Integer.MIN_VALUE;
			maxR = Integer.MIN_VALUE;
			max = Integer.MIN_VALUE;
			maxG = func(list, "R") > maxG ? func(list, "R") : maxG;
			maxR = func(list, "B") > maxR ? func(list, "B") : maxR;
			max = max < maxG ? maxG : max;
			max = max < maxR ? maxR : max;
			if (max == maxG) {
				initColor(list, "G");
				initColor(list, "R");

			} else {
				initColor(list, "R");
				initColor(list, "G");
			}
		}
		System.out.println(count);
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i));
		}

	}

	public static int func(ArrayList<String> list, String color) {
//		找到这个颜色在此串的最大长度，隔三
		int count0 = 0;
		int count1 = 0;
		int count2 = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).equals(color)) {
				count0 = i % 3 == 0 ? count0++ : count0;
				count1 = i % 3 == 1 ? count1++ : count1;
				count2 = i % 3 == 2 ? count2++ : count2;
			}
		}
		count0 = count0 < count1 ? count1 : count0;
		count0 = count0 < count2 ? count2 : count0;
		return count0;
	}

	public static void initColor(ArrayList<String> list, String color) {
		int start = list.indexOf(color);
		for (int i = start + 3; i <= list.size() - 1; i += 3) {
			if (!list.get(i).equals(color)) {
				count++;
				list.set(i, color);
			}
		}

		for (int i = start - 3; i >= 0; i -= 3) {
			if (!list.get(i).equals(color)) {
				count++;
				list.add(i, color);
			}
		}

	}

}
