import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int M = N/2;

        long[] aArr = new long[M];
        long[] bArr = new long[N-M];

        st = new StringTokenizer(br.readLine());

        long[] arr = new long[N];

        for(int i=0; i<N; i++){
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr);

        for(int i=0; i<M; i++){
            aArr[i] = arr[i];
        }
        for(int i=M; i<N; i++){
            bArr[i-M] = arr[i];
        }

        int aNum = M;
        int bNum = N-M;

        long[] aSum = new long[1<<aNum];
        long[] bSum = new long[1<<bNum];

        for(int i=0; i< 1<< aNum; i++){
            for(int j=0; j<aNum; j++){
                if((i & (1<<j)) >0){
                    aSum[i] += arr[j] ;
                }
            }
        }


        for(int i=0; i< 1<< bNum; i++){
            for(int j=0; j<bNum; j++) {
                if ((i & (1 << j)) > 0) {
                    bSum[i] += arr[j+M];
                }
            }
        }


        Arrays.sort(aSum);
        Arrays.sort(bSum);

        long cnt = 0;

        if(S == 0){
            // 답이 0일때는 0이 하나 더 나옴.
            cnt--;
        }
        for(int i=0; i<aSum.length; ){
            long a = aSum[i];
            long b = S - a;

            long aCnt = upper_bound(a, aSum) - lower_bound(a, aSum);
            long bCnt = upper_bound(b, bSum) - lower_bound(b, bSum);

            cnt += aCnt * bCnt;
            i += (int) aCnt;
        }
        System.out.println(cnt);
    }
    public static int upper_bound(long num, long[] arr){
        int left = 0;
        int right = arr.length;

        while (left<right){
            int mid = (left+right)/2;

            if(arr[mid] <= num){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return right;
    }

    public static int lower_bound(long num, long[] arr){
        int left = 0;
        int right = arr.length;

        while (left<right){
            int mid = (left+right)/2;

            if(arr[mid] >= num){
                right = mid;
            }else {
                left = mid + 1;
            }
        }
        return right;
    }
}