	package luogu_sort;
	
	import java.util.Scanner;
	import java.util.Set;
	import java.util.TreeSet;
	
	public class P1059 {
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int n = sc.nextInt();
			Set<Integer> set = new TreeSet<Integer>();
			for (int i = 0; i < n; i++) {
				set.add(sc.nextInt());
			}
			String res = "";
			for (Integer i : set) {
				res += i + " ";
			}
			System.out.println(set.size());
			System.out.println(res.trim());
	
		}
	}
