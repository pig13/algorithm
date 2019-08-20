package div3_547;
import java.util.Scanner;

public class result_A{

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int m = scan.nextInt();	
		if(m%n!=0) {
			System.out.println(-1);
			return;
		}	
		int num  = m/n;	
		int flag= 0;
		int count = 0;
		while(!(num==1)) {
			if(num%2==0) {	
				num = num/2;
				count++;
			}else if(num%3==0) {			
				num = num/3;	
				count++;
			}else {
				flag = 1;
				break;	
			}			
		}
		if(flag==1) System.out.println(-1);
		else System.out.println(count);
	}
	
}
