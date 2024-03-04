import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        arr = new int[M];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(search());

    }
    public static int search(){
        int left = arr[0];
        int right = N;

        int ans = N;
        while (left <= right){
            int mid = (left+right)/2;
            if(cal(mid)){
                ans = Math.min(mid, ans);
                right = mid - 1;
            }else{
                left = mid+1;
            }
        }
        return ans;
    }
    public static boolean cal(int mid){
        int last = arr[0];

        for(int i=1; i<M; i++){
            if(last+mid < arr[i]-mid){
                return false;
            }
            last = arr[i];
        }
        if(last+mid < N){
            return false;
        }else{
            return true;
        }
    }
}