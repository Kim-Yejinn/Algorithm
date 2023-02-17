import java.util.Scanner;

public class SWEA_1204_최빈수구하기 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();

		for(int i=1; i<=T; i++) {
			int N=sc.nextInt();			
			int[] arr=new int[101];
			
			for(int j=0; j<1000;j++ ) {
				int temp=sc.nextInt();
				arr[temp]+=1;
			}
			int max=0;
			int freq=0;
			for(int j=0; j<101;j++ ) {
				
				if(arr[j]>=max) {
					freq=j;
				max=arr[j];	
				}
			}
			
			System.out.printf("#%d %d\n", N,freq);
			
			
			
		}
		
		
	}
}
