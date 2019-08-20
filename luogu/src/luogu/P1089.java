package luogu;

import java.util.Scanner;

public class P1089 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int saveMoney = 0;
		int remainMoney = 0;
		int curMoney = 0;
		int budgetMoney = 0;
		for (int i = 1; i <= 12; i++) {
			budgetMoney = sc.nextInt();
			curMoney = remainMoney + 300;
			if (budgetMoney > curMoney) {
				System.out.println("-" + i);
				return;
			}
			saveMoney += (curMoney - budgetMoney) / 100 * 100;
			remainMoney = (curMoney - budgetMoney) % 100;
		}
		System.out.println((int) (saveMoney * 1.2 + remainMoney));

	}
}
