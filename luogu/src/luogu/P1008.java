package luogu;

public class P1008 {
	public static void main(String[] args) {
		for (int i = 192; i < 333; i++) {
			if (func(i, i * 2, i * 3)) {
				System.out.println(i + " " + i * 2 + " " + i * 3);
			}
		}
	}

	public static boolean func(int a, int b, int c) {
		String str = a + "" + b + "" + c;
		if (str.contains("1") && str.contains("2") && str.contains("3") && str.contains("4") && str.contains("5")
				&& str.contains("6") && str.contains("7") && str.contains("8") && str.contains("9")) {
			return true;
		}

		return false;
	}

}
