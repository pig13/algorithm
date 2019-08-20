package note;

public class test {
	public static void main(String[] args) {
		System.out.println(max(1, 2));
		System.out.println(max(11, 2));
	}

	public static int max(int a, int b) {
		// 短路
		int c = a;
		boolean flag = b > a && (c = b) > 1;
		return c;

	}

}
