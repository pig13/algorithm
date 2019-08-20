package div3_544;

import java.util.Scanner;

public class result_A {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String start = sc.nextLine();
		String end = sc.nextLine();
		String[] start2 = start.split(":");
		String[] end2 = end.split(":");
		int startH = Integer.parseInt(start2[0]);
		int startM = Integer.parseInt(start2[1]);
		int endH = Integer.parseInt(end2[0]);
		int endM = Integer.parseInt(end2[1]);
		startM = startH * 60 + startM;
		endM = endH * 60 + endM;
		int midH;
		int midM;
		midH = (endM+startM)/120;
		midM = (endM+startM)/2%60;
		fun(Integer.toString(midH));
		System.out.print(":");
		fun(Integer.toString(midM));
	}
	static void fun(String s) {
		if(s.length()==1) {
			System.out.print("0"+s);
		}else {
			System.out.print(s);
		}
	}
}
