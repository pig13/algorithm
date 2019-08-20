package luogu;

import java.util.Scanner;

public class P1308 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String word = sc.nextLine().toLowerCase();
		String str = sc.nextLine().toLowerCase();
		String str2 = str.toLowerCase().trim();
		String[] words = str2.split(" ");
		int start = -1;
		int count = 0;
		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(word)) {
				if (start == -1) {
					if (i == 0) {
						start = str.indexOf(word);
					} else if (i == words.length - 1) {
						start = str.lastIndexOf(word);
					} else {
						start = str.indexOf(" " + word + " ") + 1;
					}
				}
				count++;
			}
		}
		if (count == 0) {
			System.out.println(start);
		} else {
			System.out.println(count + " " + start);
		}

	}
}
