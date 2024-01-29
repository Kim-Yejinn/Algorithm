import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static long[] arr; // 값 저장
    static int[] tree; // idx
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());

            if(N==0){
                break;
            }

            arr = new long[N+1];
            tree = new int[4*N];

            for(int i=1; i<=N; i++){
                arr[i] = Long.parseLong(st.nextToken());
                update(i, 1, 1, N);
            }
            System.out.println(maxArea(1, N));
        }
    }
    public static void update(int X, int node, int S, int E){
        if(S==E){
            tree[node] = X;
            return;
        }
        int mid = (S + E) / 2;
        if( X <= mid){
            update(X, 2*node, S, mid);
        }else{
            update(X, 2*node+1, mid+1, E);
        }

        if(arr[tree[2*node]] <= arr[tree[2*node+1]]){
            tree[node] = tree[2*node];
        }else{
            tree[node] = tree[2*node+1];
        }
    }
    public static int query(int L, int R, int node, int S, int E){
        if(R < S || E < L){
            return -1;
        }
        if(L <= S && E <=R){
            return tree[node];
        }

        int mid = (S+E)/2;
        int leftIdx = query(L, R, 2*node, S, mid);
        int rightIdx = query(L, R, 2*node+1, mid+1, E);

        if(leftIdx == -1){
            return rightIdx;
        }
        if(rightIdx == -1){
            return leftIdx;
        }

        if(arr[leftIdx] <= arr[rightIdx]){
            return leftIdx;
        }else{
            return rightIdx;
        }
    }
    public static long maxArea(int L, int R){
        int minIdx = query(L, R, 1, 1, N);

        long area = (R-L+1) * arr[minIdx];

        if(minIdx-1 >= L){
            area = Math.max(area, maxArea(L, minIdx-1));
        }
        if(minIdx+1 <= R){
            area = Math.max(area, maxArea(minIdx+1, R));
        }
        return area;
    }
}