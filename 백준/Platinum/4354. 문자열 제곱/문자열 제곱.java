import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] pi;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            String str = br.readLine();
            int len = str.length();
            if(str.equals(".")){
                break;
            }
            pi = new int[len];
            getPi(str);
            int rec = len - pi[len-1];
            if(len%rec == 0){
                System.out.println(len/rec);
            }else{
                System.out.println(1);
            }
        }
    }
    public static void getPi(String str){
        int j=0;

        for(int i=1; i<str.length(); i++){
            while (j>0 && str.charAt(i) != str.charAt(j)){
                j = pi[j-1];
            }
            if(str.charAt(i)==str.charAt(j)){
                j++;
            }
            pi[i] = j;
        }
    }
}