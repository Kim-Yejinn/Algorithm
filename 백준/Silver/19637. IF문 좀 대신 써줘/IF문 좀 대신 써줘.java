import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int M;
    static int idx;
    static int[] arr;
    static String[] str;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        str = new String[N];
        idx = 0;

        int last = -1;
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            String temp = st.nextToken();
            int temp2 = Integer.parseInt(st.nextToken());

            if(last != temp2){
                arr[idx] = temp2;
                str[idx] = temp;
                last = temp2;
                idx++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int temp = search(Integer.parseInt(st.nextToken()));
            sb.append(str[temp]).append("\n");
        }
        System.out.println(sb);
    }
    public static int search(int num){
        int left = 0;
        int right = idx-1;

        int result = idx-1;
        while(left<=right){
            int mid = (left+right)/2;

            if(arr[mid]>=num){
                result = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return result;
    }
}