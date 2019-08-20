package div3_540;

import java.util.Scanner;

public class A{

	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int q = scan.nextInt();
		long arr[][] = new long[q][3];
			
		for(int i = 0;i < q;i++){
			for(int j = 0;j < 3;j++){
				
				arr[i][j]  = scan.nextLong();		
			}	
		}
			
		Long Ans[] = new  Long[q];
			
		for(int i = 0;i < q;i++){
			if(arr[i][1] == arr[i][2]/2){						
					Ans[i] = arr[i][0]*arr[i][1];			
			}
			else if(arr[i][1] < arr[i][2]/2){			
				Ans[i] = arr[i][0]*arr[i][1];				
			}else{		
				long num = arr[i][0]/2;	
				if(arr[i][0]%2==0){
					Ans[i] = num*arr[i][2];
				}else
			    		Ans[i] = num*arr[i][2] + arr[i][1];	
			}	
		}
		
		for(int i = 0;i < Ans.length;i++){	
			System.out.println(Ans[i]);	
		}		
	}
}