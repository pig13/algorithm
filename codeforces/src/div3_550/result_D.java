package div3_550;
import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class result_D {

	static Scanner scan = new Scanner(new BufferedInputStream(System.in));
	static ArrayList<Integer> list = new ArrayList<>();
	static Map<Integer, Integer> map = new HashMap<>();
	static int balance;
	static void fun(StringBuffer sb,int now,int last) {
		if(list.get(now)<balance) {
			sb.append(1+" "+(now+1)+" "+(last+1)+"\n");
		}
		if(list.get(now)>balance) {
			sb.append(2+" "+(now+1)+" "+(last+1)+"\n");
		}
	}
	public static void main(String[] args) {
		int n = scan.nextInt();
		for (int i = 0; i < n; i++) {
			int temp = scan.nextInt();
			list.add(temp);
			if (map.containsKey(temp)) {
				map.put(temp, map.get(temp) + 1);
			} else {
				map.put(temp, 1);
			}
		}
		if (map.size() == 1) {
			System.out.println("0");
		} else {
			int max = 0;
			for (Integer i : map.keySet()) {
				int val = map.get(i);
				if (val > max) {
					max = val;
					balance = i;
				}
			}
			StringBuffer sb = new StringBuffer();
			int count=0;
			for (int i = list.size()-2; i >=0; i--) {
				if(list.get(i+1)==balance&&list.get(i)!=balance) {
					fun(sb, i, i+1);
					list.set(i, balance);
					count++;
				}
			}
			for (int i = 1; i < list.size(); i++) {
				if(list.get(i-1)==balance&&list.get(i)!=balance) {
					fun(sb, i, i-1);
					list.set(i, balance);
					count++;
				}
			}
			System.out.println(count);
			System.out.println(sb);
		}

	}
}
