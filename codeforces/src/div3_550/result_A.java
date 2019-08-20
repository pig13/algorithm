package div3_550;
import java.io.BufferedInputStream;
import java.util.Arrays;
import java.util.Scanner;

public class result_A {

	static Scanner scan = new Scanner(new BufferedInputStream(System.in));
	static String str = "abcdefghijklmnopqrstuvwxyz";

	public static void main(String[] args) {
		char[] temp = null;
		int n = scan.nextInt();
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < n; i++) {
			boolean flag = false;
			temp = scan.next().toCharArray();
			if (temp.length == 1) {

				sb.append("YES\n");
			} else {
				Arrays.sort(temp);
				String s = new String(temp);
				if (!str.contains(s)) {
					sb.append("NO\n");
				} else
					sb.append("YES\n");
			}
		}
		System.out.println(sb);
	}
}
