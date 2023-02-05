import java.util.Scanner;

public class SWEA_2019_더블더블 {
public static void main(String[] args) {
	Scanner sc=new Scanner(System.in);
	
	int num=sc.nextInt();
	int total=1;
	
	for(int i=0; i<=num;i++) {
		
		System.out.print(total+" ");
		total*=2;
	}
}
	
	
}
