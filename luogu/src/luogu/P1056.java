package luogu;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class P1056 {

	static class comparatorValue implements Comparator<Entry<Integer, Integer>> {
		@Override
		public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
			// TODO Auto-generated method stub
			return o2.getValue() - o1.getValue();
		}
	}

	static class comparatorKey implements Comparator<Entry<Integer, Integer>> {
		@Override
		public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
			// TODO Auto-generated method stub
			return o1.getKey() - o2.getKey();
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int k = sc.nextInt();
		int l = sc.nextInt();
		int d = sc.nextInt();
		Map<Integer, Integer> rowMap = new HashMap<Integer, Integer>();
		Map<Integer, Integer> colMap = new HashMap<Integer, Integer>();
		int x;
		int y;
		int p;
		int q;
		int tmp;
		for (int i = 0; i < d; i++) {
			x = sc.nextInt();
			y = sc.nextInt();
			p = sc.nextInt();
			q = sc.nextInt();
			if (x == p) {
				tmp = Math.min(y, q);
				if (!colMap.containsKey(tmp)) {
					colMap.put(tmp, 1);
				} else {
					colMap.put(tmp, colMap.get(tmp) + 1);
				}
			} else {
				tmp = Math.min(x, p);
				if (!rowMap.containsKey(tmp)) {
					rowMap.put(tmp, 1);
				} else {
					rowMap.put(tmp, rowMap.get(tmp) + 1);
				}
			}
		}
		List<Entry<Integer, Integer>> rowList = new ArrayList<Entry<Integer, Integer>>(rowMap.entrySet());
		List<Entry<Integer, Integer>> colList = new ArrayList<Entry<Integer, Integer>>(colMap.entrySet());
		Collections.sort(rowList, new comparatorValue());
		Collections.sort(colList, new comparatorValue());
		rowList = rowList.subList(0, k);
		colList = colList.subList(0, l);
		Collections.sort(rowList, new comparatorKey());
		Collections.sort(colList, new comparatorKey());
		for (int i = 0; i < k; i++) {
			if (i == k - 1) {
				System.out.println(rowList.get(i).getKey());
			} else {
				System.out.print(rowList.get(i).getKey() + " ");

			}
		}
		for (int i = 0; i < l; i++) {
			if (i == l - 1) {
				System.out.println(colList.get(i).getKey());
			} else {
				System.out.print(colList.get(i).getKey() + " ");
			}
		}

//		ArrayList<Integer> rowKey = new ArrayList<Integer>();
//		ArrayList<Integer> colKey = new ArrayList<Integer>();
//
//		int maxKey = Integer.MIN_VALUE;
//		int maxValue = Integer.MIN_VALUE;
//		for (int i = 0; i < k; i++) {
//			maxValue = Integer.MIN_VALUE;
//			for (Integer key : rowMap.keySet()) {
//				if (rowMap.get(key) > maxValue) {
//					maxValue = rowMap.get(key);
//					maxKey = key;
//				}
//			}
////			if (i == k - 1) {
////				System.out.println(maxKey);
////			} else {
////				System.out.print(maxKey + " ");
////			}
//			rowKey.add(maxKey);
//			rowMap.remove(maxKey);
//		}
//		for (int i = 0; i < l; i++) {
//			maxValue = Integer.MIN_VALUE;
//			for (Integer key : colMap.keySet()) {
//				if (colMap.get(key) > maxValue) {
//					maxValue = colMap.get(key);
//					maxKey = key;
//				}
//
//			}
////			if (i == l - 1) {
////				System.out.println(maxKey);
////			} else {
////				System.out.print(maxKey + " ");
////			}
//			colKey.add(maxKey);
//			colMap.remove(maxKey);
//		}
//		Collections.sort(rowKey);
//		Collections.sort(colKey);
//
//		System.out.println(rowKey.toString().substring(1, rowKey.toString().length() - 1).replace(",", ""));
//		System.out.println(colKey.toString().substring(1, colKey.toString().length() - 1).replace(",", ""));

	}
}
