import java.util.Arrays;
import java.util.Scanner;

public class SWEA_3499_퍼펙트셔플 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int i = 1; i <= T; i++) {

			int N = sc.nextInt();
			
			int flag=0;
			if(N%2==0) {
				flag=0;
			}else {
				flag=1;
			}

			String[] odd=new String[N/2+flag];
			String[] even=new String[N/2];
			
			for (int j = 0; j < N; j++) {
				String input = sc.next();
				
				if(j <(N/2 + flag)) {
					odd[j]=input;
				}
				
				else {
					even[j-N/2-flag]=input;
				}				
			}
			System.out.print("#"+i+" ");	
			
			
			for(int k=0; k<N/2; k++) {
				System.out.print(odd[k]+" ");
				System.out.print(even[k]+" ");
			}
			if(flag==1) {
				System.out.print(odd[N/2]);
			}
			
			System.out.println();
			

		}

	}
}
