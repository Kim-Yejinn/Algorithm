import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] aArr = new int[N];
        for(int i=0; i<N; i++){
            aArr[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] bArr = new int[M];
        for(int i=0; i<M; i++) {
            bArr[i] = Integer.parseInt(st.nextToken());
        }

        long[] aSum = new long[N*(N+1)/2];
        long[] bSum = new long[M*(M+1)/2];

        int idx = 0;
        for(int i=0; i<N; i++){
            long sum = 0;
            for(int j=i; j<N; j++){
                sum += aArr[j];
                aSum[idx++] = sum;
            }
        }

        idx = 0;
        for(int i=0; i<M; i++){
            long sum = 0;
            for(int j=i; j<M; j++){
                sum += bArr[j];
                bSum[idx++] = sum;
            }
        }

        Arrays.sort(aSum);
        Arrays.sort(bSum);

        long cnt = 0;
        for(int i=0; i<aSum.length; ) {
            long a = aSum[i];
            long b = T - aSum[i];

            long aCnt = upper_bound(a, aSum) - lower_bound(a, aSum);
            long bCnt = upper_bound(b, bSum) - lower_bound(b, bSum);

            cnt += aCnt * bCnt;
            i += aCnt;
        }
        System.out.println(cnt);
    }
    public static int upper_bound(long num, long[] arr){
        int left = 0;
        int right = arr.length;

        while (left < right){
            int mid = (left+right)/2;

            if(arr[mid] <= num){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        return right;
    }

    public static int lower_bound(long num, long[] arr){
        int left = 0;
        int right = arr.length;

        while (left < right){
            int mid = (left+right)/2;

            if(arr[mid] >= num){
                right = mid;
            }else{
                left = mid+1;
            }
        }
        return right;
    }
}