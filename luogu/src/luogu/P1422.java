package luogu;

import java.util.Scanner;

public class P1422 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		float time = sc.nextFloat();
		float money = 0;
		if (time >= 401) {
			money += (time - 400) * 0.5663;
			time = 400;
		}
		if (time >= 151) {
			money += (time - 150) * 0.4663;
			time = 150;
		}
		money += time * 0.4463;
		System.out.println(String.format("%.1f", money));
	}
}
