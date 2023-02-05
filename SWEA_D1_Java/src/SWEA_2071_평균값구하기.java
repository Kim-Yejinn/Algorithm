import java.util.Scanner;

public class SWEA_2071_평균값구하기 {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	
	int T=sc.nextInt();
	int[] num=new int[10];
	int total=0;
	double avg=0;
	
	for(int i=1; i<=T; i++) {
		
		for(int j=0; j<10;j++) {
			num[j]=sc.nextInt();
			total+=num[j];
			
		}
		avg=Math.round((total*1.0)/num.length);
		System.out.println("#"+i+" "+(int)avg);
		total=0;
		
	}
	
}
}
