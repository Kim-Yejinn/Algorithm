import java.util.Scanner;

public class SWEA_1284_수도요금경쟁 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		
		for(int i=1; i<=T;i++) {
			int P=sc.nextInt();//A사 리터당 돈
			int Q=sc.nextInt();//B사 기본요금
			int R=sc.nextInt();//B사 기준
			int S=sc.nextInt();//B사 리터당 요금
			int W=sc.nextInt();//한달 사용량
			
			int A=W*P;
			int B=W-R<0?Q:Q+(W-R)*S;

			int ans=A-B>=0?B:A;
			System.out.printf("#%d %d\n",i,ans);
			
		}
		
		
	}
}
