package algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Hello extends Test1 {
	static int a;

	public Hello() {
		// TODO Auto-generated constructor stub
		super();
//		int b = super.aaa;
	}

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>(10000000);
		map.put("asd", "asdasd");
		System.out.println(map.size());
		Scanner sc = new Scanner(System.in);
		System.out.println(sc.nextLine());

	}

	public static Integer addNum(int num) {
		return num + 1;
	}

}
