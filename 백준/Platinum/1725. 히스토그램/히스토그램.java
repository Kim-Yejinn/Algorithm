import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    static int[] tree; // minIdx를 저장
    static int[] arr; // 높이
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        tree = new int[4*N];
        arr = new int[N+1];

        for(int i=1; i<=N; i++){
            int num = Integer.parseInt(br.readLine());
            arr[i] = num;
            update(i, 1, 1, N);
        }
        System.out.println(maxArea(1, N));
    }
    public static void update(int X, int node, int S, int E){
        // 값 넣기
        if(S==E){
            tree[node] = X;
            return;
        }

        int mid = (S+E)/2;

        if(X <=mid){
            update(X, 2*node, S, mid);
        }else{
            update(X, 2*node+1, mid+1, E);
        }

        int leftH = arr[tree[2*node]];
        int rightH = arr[tree[2*node+1]];


        if(leftH <= rightH){
            tree[node] = tree[2*node];
        }else{
            tree[node] = tree[2*node+1];
        }
    }
    public static int query(int L, int R, int node, int S, int E){
        // minIdx 구하기
        if(R < S || E < L){
            return -1;
        }
        if( L <= S && E <= R){
            return tree[node];
        }

        int mid = (S + E)/2;
        int leftIdx = query(L, R, 2*node, S, mid);
        int rightIdx = query(L, R, 2*node+1, mid+1, E);

        if (leftIdx == -1){
            return rightIdx;
        }
        if (rightIdx == -1){
            return leftIdx;
        }
        if(arr[leftIdx] <= arr[rightIdx]){
            return leftIdx;
        }else{
            return rightIdx;
        }
    }
    public static int maxArea(int L, int R){
        int minIdx = query(L, R, 1, 1, N);

        // 지금
        int area = (R-L+1) * arr[minIdx];

        if(L <= minIdx-1){
            // 왼쪽
            area = Math.max(area, maxArea(L, minIdx-1));
        }
        if(R >= minIdx+1){
            // 오른쪽
            area = Math.max(area, maxArea(minIdx+1, R));
        }
        return area;
    }
}