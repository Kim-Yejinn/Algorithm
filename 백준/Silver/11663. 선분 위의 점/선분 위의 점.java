import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];

        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int idx1 = search2(a);
            int idx2 = search1(b);

            if(a<arr[0] && b<arr[0]){
                sb.append("0\n");
                continue;
            }
            if(a>arr[N-1] && b>arr[N-1]){
                sb.append("0\n");
                continue;
            }
//            System.out.println(idx2+"/"+idx1);
            sb.append(idx2-idx1+1).append("\n");
        }
        System.out.println(sb);
    }
    public static int search1(int num){
        // 그 점보다 작은것
        int left = 0;
        int right = N-1;

        int result = N-1;
        while(left<=right){
            int mid = (left+right)/2;

            if(num>=arr[mid]){
                result = mid;
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return result;
    }
    public static int search2(int num){
        // 그 점보다 큰것
        int left = 0;
        int right = N-1;

        int result = 0;
        while(left <= right){
            int mid = (left+right)/2;

            if(num<=arr[mid]){
                result = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return result; 
    }
}