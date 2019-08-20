package CodeforcesGlobalRound2Editorial;

import java.math.BigInteger;
import java.util.LinkedList;
import java.util.Scanner;

public class A {
	public static int maxWalk1(LinkedList<Integer> list, int num) {
		int left = 0;
		int right = list.size() - 1;
		for (; list.get(left) == list.get(right); left++) {
		}
		int diff = right - left;
		left = 0;
		right = list.size() - 1;
		for (; list.get(left) == list.get(right); right--) {
		}
		diff = right - left > diff ? right - left : diff;
		return diff;

	}

	public static int maxWalk2(LinkedList<Integer> list, int num) {
		int maxDiff = Integer.MIN_VALUE;
		for (int i = 0; i < list.size(); i++) {
			for (int j = list.size() - 1; j > i; j--) {
				if (list.get(i) != list.get(j)) {
					if (j - i > maxDiff) {
						maxDiff = j - i;
					}
					break;
				}
			}
		}
		return maxDiff;
	}

	public static LinkedList<Integer> generateRandomList(int maxSize, int maxValue) {
		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int i = 0; i < maxSize; i++) {
			list.add((int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random()));
		}
		return list;
	}

	public static LinkedList<Integer> IO() {
		LinkedList<Integer> list = new LinkedList<Integer>();
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		for (int i = 0; i < size; i++) {
			list.add(sc.nextInt());
		}
		return list;

	}

	public static void main(String[] args) {
//		int testTime = 500000000;
		BigInteger testTime = new BigInteger("5000000000000000000000000000000000");
		int maxSize = 30;
		int maxValue = 30;
		boolean succeed = true;
		for (BigInteger i = new BigInteger("1"); !testTime.equals(i); i.add(new BigInteger("1"))) {
			LinkedList<Integer> list = generateRandomList(maxSize, maxValue);
			if (maxWalk1(list, maxSize) != maxWalk2(list, maxSize)) {
				succeed = false;
				System.out.println(list);
				break;
			}
//			System.out.println(i);
		}
		System.out.println(succeed ? "Nice!" : "Fucking fucked!");

	}

}
