import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static long[] time;
    static int N;
    static int M;
    static long MAX = 1_000_000_000_000_000_000L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        time = new long[N];
        for(int i=0; i<N; i++){
            time[i] = Integer.parseInt(br.readLine());

        }
        System.out.println(search());

    }

    public static long search(){
        long left = 0;
        long right = MAX;

        long ans = 0;

        while (left <= right){
            long mid = (left+right)/2;

            long temp = cal(mid);

            if(temp >= M){
                right = mid - 1;
                ans = mid;
            }else{
                left = mid + 1;
            }
        }
        return ans;
    }

    public static long cal(long num){
        long sum = 0;
        for(int i=0; i<N; i++){
            sum += num/time[i];
            if(sum >=M){
                return M;
            }
        }
        return sum;
    }
}