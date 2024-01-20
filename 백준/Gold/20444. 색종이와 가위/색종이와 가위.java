import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long N;
    static long K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Long.parseLong(st.nextToken());
        K = Long.parseLong(st.nextToken());

        if(search()){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }

    }
    public static boolean search(){
        long left = 0;
        long right = N;

        boolean check = false;

        while(left<=right){
            long mid = (left+right)/2;

            long temp = cal(mid);

            if(temp == K){
                check = true;
                break;
            }else if(temp > K){
                right = mid -1;
            }else{
                left = mid + 1;
            }
        }
        return check;
    }
    public static long cal(long a){
        long b = N-a;
        return (a+1)*(b+1);
    }
}