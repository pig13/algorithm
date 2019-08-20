package div3_535;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class D {

	static Scanner scan = new Scanner(new BufferedInputStream(System.in));
	static char[] data, data1;
	static int n;

	public static void main(String[] args) {
		n = scan.nextInt();
		data = scan.next().toCharArray();
		data1 = new char[data.length];

		for (int i = data1.length - 2; i >= 0; i--) {
			data1[i] = data[i + 1];
		}
		int count = 0;
		for (int i = 1; i < data.length; i++) {
			if (data[i - 1] == data[i]) {
				data[i] = other(data[i], data1[i]);
				count++;
			}
		}
		System.out.println(count);
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i]);
		}
	}

	static char other(char now, char last) {
		char[] color = { 'G', 'B', 'R' };
		for (int i = 0; i < color.length; i++) {
			if (color[i] == now || color[i] == last) {
				color[i] = 0;
			}
		}
		char result = 0;
		for (int i = 0; i < color.length; i++) {
			if (color[i] != 0) {
				result = color[i];
			}
		}
		return result;
	}
}
