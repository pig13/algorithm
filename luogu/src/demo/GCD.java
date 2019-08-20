package demo;

public class GCD {
	public static void main(String[] args) {

		String ss = "adaasdasgfasdabcdd";
		ss = ss.replaceAll("(.).\\1", "");
		System.out.println(ss);

	}

	public static int gcd(int a, int b) {
		// 计算a,b的最大公约数
		if (b == 0) {
			return a;
		}
		return gcd(b, a % b);
	}
}
