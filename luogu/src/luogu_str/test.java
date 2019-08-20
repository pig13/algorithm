package luogu_str;

import java.util.Arrays;

public class test {
	public static void main(String[] args) {
//		QWERTYUIOPLKJHGFDSAZXCVBN 
//		ABCDEFGHIJKLMNOPQRSTUVWXY 
//		DSLIEWO
		char[] ss = "QWERTYUIOPLKJHGFDSAZXCVBN".toCharArray();
		Arrays.sort(ss);
		for (int i = 0; i < ss.length; i++) {
			System.out.print(ss[i] + " ");

		}
		System.out.println(ss.length);

	}

}
