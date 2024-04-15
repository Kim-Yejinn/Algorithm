import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int mulOdd = 1;
        int mulEven = 1;
        boolean flag = false;
        for(int i=0; i<3; i++){
            int temp = Integer.parseInt(st.nextToken());

            if(temp % 2 == 0){
                mulEven *= temp;
            }else{
                mulOdd *= temp;
                flag = true;
            }
        }

        if(flag){
            System.out.println(mulOdd);
        }else{
            System.out.println(mulEven);
        }
    }
}