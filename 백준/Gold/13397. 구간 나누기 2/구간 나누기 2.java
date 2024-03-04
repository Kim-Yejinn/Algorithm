import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[N];

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(search());

    }
    public static int search(){
        //upper bound
        int left = 0;
        int right = 5000*10000;

        while (left<right){
            int mid = (left+right)/2;

            int ret = cal(mid);

            if(ret <= M){
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return right;
    }
    public static int cal(int num){
        int cnt = 0;

        for(int i=0; i<N && cnt <= M; cnt++){
            int min = arr[i];
            int max = arr[i];
            int j = i;

            while (j < N){
                int tMin = Math.min(min, arr[j]);
                int tMax = Math.max(max, arr[j]);

                if(tMax-tMin > num){
                    break;
                }

                min = tMin;
                max = tMax;
                j++;
            }
            i = j;
        }
        return cnt;
    }
}