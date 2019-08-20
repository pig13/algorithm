package div3_540;
import java.util.ArrayList;
import java.util.Scanner;

public class B{

	static Scanner scan = new Scanner(System.in);
	static ArrayList<num> list = new ArrayList<>();
	static num allnum;

	public static void main(String[] args) {
		int n = scan.nextInt();
		if(n==1){
			System.out.println(1);
			return;
		}
		if(n==2){
			System.out.println(0);
			return;
		}
		num num;
		for (int i = 0; i < n; i++) {
			num = new num();
			num.data = scan.nextInt();
			list.add(num);
		}
		num = list.get(1);
		num.oddsum = list.get(0).data;
		for (int i = 2; i < n; i++) {
			num = list.get(i);
			if (i % 2 != 0) {
				num.evensum = list.get(i - 1).evensum;
				num.oddsum = list.get(i - 2).oddsum + list.get(i - 1).data;
			} else {
				num.evensum = list.get(i - 2).evensum + list.get(i - 1).data;
				num.oddsum = list.get(i - 1).oddsum;
			}
		}
		allnum = new num();
		if (n % 2 == 0) {
			allnum.evensum = list.get(n - 1).evensum + list.get(n - 1).data;
			allnum.oddsum = list.get(n - 1).oddsum;
		} else {
			allnum.evensum = list.get(n - 1).evensum;
			allnum.oddsum = list.get(n - 1).oddsum + list.get(n - 1).data;
		}
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (fun(i))
				count++;
		}
		System.out.println(count);
	}

	static boolean fun(int i) {
		num num = list.get(i);
		int oddleft = num.oddsum;
		int evenleft = num.evensum;
		int oddright = allnum.evensum - evenleft;
		int evenright = allnum.oddsum - oddleft;
		if (i % 2 != 0) {
			oddright = oddright - num.data;
		} else {
			evenright = evenright - num.data;
		}
		return (oddleft + oddright) == (evenleft + evenright);
	}

	static class num {
		int data;
		int oddsum;
		int evensum;
	}
}