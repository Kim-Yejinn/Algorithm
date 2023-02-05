import java.util.Scanner;

public class SWEA_12368_24시간 {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	
	int T= sc.nextInt();
	
	for(int i=1; i<=T;i++) {
		int First=sc.nextInt();
		int Second=sc.nextInt();
		
		int sum=First+Second;
		
		if(sum>=24) {
			sum-=24;
		}
		
		System.out.println("#"+i+" "+sum);
			
		
	}
}
}
