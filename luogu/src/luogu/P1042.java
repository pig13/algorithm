package luogu;

import java.util.ArrayList;
import java.util.Scanner;

public class P1042 {

	static class Person {
		boolean is11; // 是否是 11 局次
		int w; // 记录当前局赢的次数
		int l; // 记录当前局输的次数
		boolean flag = false; // 最后一次不完整的对局
		ArrayList<Integer> W; // 成绩记录 win
		ArrayList<Integer> L; // 成绩记录

		public void check() {
			// 检查当前对局是否结束
			if (is11) {
				if (((w >= 11 | l >= 11) && Math.abs(this.w - this.l) >= 2) || flag) {
					W.add(this.w);
					L.add(this.l);
					w = 0;
					l = 0;
				}
			} else {
				if (((w >= 21 || l >= 21) && Math.abs(this.w - this.l) >= 2) || flag) {
					W.add(this.w);
					L.add(this.l);
					w = 0;
					l = 0;
				}
			}
		}

	}

	public static void main(String[] args) {
		Person p11 = new Person();
		Person p21 = new Person();
		p11.is11 = true;
		p11.w = 0;
		p11.l = 0;
		p11.W = new ArrayList<>();
		p11.L = new ArrayList<>();
		p21.is11 = false;
		p21.w = 0;
		p21.l = 0;
		p21.W = new ArrayList<>();
		p21.L = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		String tmp;
		for (;;) {
			tmp = sc.next().trim();
			for (char ch : tmp.toCharArray()) {
				if (ch == 'W') {
					p11.w++;
					p21.w++;
				} else if (ch == 'L') {
					p11.l++;
					p21.l++;
				} else if (ch == 'E') {
					break;
				}
				p11.check();
				p21.check();
			}
			if (tmp.contains("E")) {
				break;
			}

		}
		p11.flag = true;
		p21.flag = true;
		p11.check();
		p21.check();

		for (int i = 0; i < p11.W.size(); i++) {
			System.out.println(p11.W.get(i) + ":" + p11.L.get(i));
		}
		System.out.println();

		for (int i = 0; i < p21.W.size(); i++) {
			System.out.println(p21.W.get(i) + ":" + p21.L.get(i));
		}
	}

}
