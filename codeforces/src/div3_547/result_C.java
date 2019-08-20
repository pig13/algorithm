package div3_547;
import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class result_C {

	static Scanner scan = new Scanner(new BufferedInputStream(System.in));
	static ArrayList<Integer>list= new ArrayList<>();
	static ArrayList<Integer>list1=new ArrayList<>();
	public static void main(String[] args) {
		int n=scan.nextInt();
		for (int i = 0; i < n-1; i++) {
			list.add(scan.nextInt());
		}
		list1.add(1);
		for (int i = 0; i < list.size(); i++) {
			list1.add(list.get(i)+list1.get(i));
		}
		int min=Integer.MAX_VALUE;
		int max=Integer.MIN_VALUE;
		for (int i = 0; i < list1.size(); i++) {
			if(list1.get(i)>max) {
				max=list1.get(i);
			}
			if(list1.get(i)<min) {
				min=list1.get(i);
			}
		}
		int temp=1-min;
		for (int i = 0; i < list1.size(); i++) {
			list1.set(i, list1.get(i)+temp);
		}
		int num=max-min+1;
		Set< Integer>set= new HashSet<>();
		for (int i = 0; i < list1.size(); i++) {
			set.add(list1.get(i));
		}
		if(set.size()==num&&set.size()==n) {
			for (int i = 0; i < list1.size(); i++) {
				System.out.print(list1.get(i)+" ");
			}
		}else {
			System.out.println(-1);
		}
		
	}
}
