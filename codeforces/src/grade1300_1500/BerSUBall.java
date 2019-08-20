package grade1300_1500;

import java.util.Arrays;
import java.util.Scanner;

public class BerSUBall {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arrN = new int[n];
		for (int i = 0; i < arrN.length; i++) {
			arrN[i] = sc.nextInt();
		}
		int m = sc.nextInt();
		int[] arrM = new int[m];
		for (int i = 0; i < arrM.length; i++) {
			arrM[i] = sc.nextInt();
		}
		Arrays.sort(arrN);
		Arrays.sort(arrM);
		int i = 0;
		int j = 0;
		int count = 0;
		for (; i < n && j < m;) {
			if (Math.abs(arrN[i] - arrM[j]) <= 1) {
				i++;
				j++;
				count++;
			} else if (arrN[i] - arrM[j] > 0) {
				j++;
			} else {
				i++;
			}
		}
		System.out.println(count);

	}
}
