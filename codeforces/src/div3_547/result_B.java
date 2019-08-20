package div3_547;
import java.util.Scanner;

public class result_B {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int arr[] = new int[2*n+1];
		for(int i = 0;i < n;i++) {	
			arr[i]= scan.nextInt();		
		}
		for(int i  = 0;i < n;i++) {	
			arr[n+i] = arr[i];	
		}
		int max=0;
		int count =1;
		for(int i =0;i <= 2*n;i++) {
			if(arr[i]==0) {	
				continue;
			}
			if(arr[i]==1) {
				if(arr[i+1]==1) {	
					count++;	
				}else {	
					if(count > max) max = count;
					count = 1;				
				}
			}	
		}
		System.out.println(max);
	}

}
