import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_10951 {
public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	String input="";
	String[] arr;
	while((input=br.readLine())!=null) {
		arr=input.split(" ");
		System.out.println(Integer.parseInt(arr[0])+Integer.parseInt(arr[1]));
		
	}
}
}
