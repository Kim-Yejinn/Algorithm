import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int L;
    static int[] rest;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        rest = new int[N+1];

        st = new StringTokenizer(br.readLine());

        for(int i=1; i<=N; i++){
            rest[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(rest);

        System.out.println(search());
    }

    public static int check(int dis){
        int cnt = 0;

        for(int i=1; i<=N; i++){
            int diff = rest[i] - rest[i-1] -1;
            cnt+= diff/dis;
        }
        int diff = L - rest[N] - 1;
        cnt += diff/dis;


        return cnt;
    }
    public static int search(){
        int left = 1;
        int right = L;
        int min = L;

        while(left<=right){
            int mid = (left+right)/2;
            int result = check(mid);

            if(M < result){
                left = mid + 1;
            }else{
                min = Math.min(min, mid);
                right = mid - 1;
            }
        }
        return min;
    }
}