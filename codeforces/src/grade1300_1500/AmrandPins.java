package grade1300_1500;

import java.util.Scanner;

public class AmrandPins {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r = sc.nextInt();
		int x = sc.nextInt();
		int y = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		double dis = Math.sqrt(Math.pow(Math.abs(x - a), 2) + Math.pow(Math.abs(y - b), 2));
		boolean flag = false;
		if (dis % (r * 2) != 0) {
			flag = true;
		}
		int res = (int) (dis / (r * 2));
		if (flag) {
			res++;
		}
		System.out.println(res);

	}
}
