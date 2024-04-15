import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int size;
    static int[] A;
    static int[] dp;
    static int[] curIdx;
    static int[] last;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new int[N];
        dp = new int[N];
        curIdx = new int[N];
        last = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(st.nextToken());
        }

        size = 1;
        dp[0] = A[0];

        for(int i=1; i<N; i++){
            if(dp[size-1] < A[i]){
                last[i] = curIdx[size-1];
                curIdx[size] = i;
                dp[size++] = A[i];
            }else{
                int idx = search(A[i]);
                if(idx == 0){
                    last[i] = i;
                }else{
                    last[i] = curIdx[idx-1];
                }
                curIdx[idx] = i;
                dp[idx] = A[i];
            }
        }

        Stack<Integer> ans = new Stack<>();

        int idx = curIdx[size-1];

        while (idx != last[idx]){
            ans.push(A[idx]);
            idx = last[idx];
        }
        ans.push(A[idx]);

        System.out.println(ans.size());
        StringBuilder sb = new StringBuilder();
        while (!ans.isEmpty()){
            sb.append(ans.pop()).append(" ");
        }
        System.out.println(sb);
    }
    public static int search(int num){
        int left = 0;
        int right = size-1;

        while (left < right){
            int mid = (left+right)/2;

            if(dp[mid] < num){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        return right;
    }
}