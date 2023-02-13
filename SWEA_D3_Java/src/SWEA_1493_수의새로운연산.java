import java.util.Scanner;

public class SWEA_1493_수의새로운연산 {
	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		
		for(int i=1; i<=T; i++) {
			
			
			int q=sc.nextInt();
			
			int p=sc.nextInt();
			
			int q_x=0, q_y=0;
			int p_x=0, p_y=0;
			
			
			int sum=1;
			int cnt=2;
			while(true) {

				if(q<=sum) {
					q_x=cnt-(sum-q)-1;
					q_y=cnt-q_x;
					sum=1;
					cnt=2;
					break;
				}
				sum+=cnt++;
			}

			while(true) {

				if(p<=sum) {
					p_x=cnt-(sum-p)-1;
					p_y=cnt-p_x;
					sum=1;
					cnt=2;
					break;
				}
				sum+=cnt++;
			}
			
			
			int t_x=p_x+q_x;
			int t_y=p_y+q_y;
			
			int result = (t_x+t_y-1)*(t_x+t_y)/2-(t_x+t_y-1-t_x);
			System.out.printf("#%d %d\n",i,result);
			
			
			
		}		
	}
	
	
	
	
	
}
