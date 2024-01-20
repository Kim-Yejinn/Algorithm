import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static class Node{
        int idx;
        int num;
        Node(int idx, int num){
            this.idx = idx;
            this.num = num;
        }
    }
    static int[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        tree = new int[4*N];
        List<Node> list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++){
            list.add(new Node(i, Integer.parseInt(st.nextToken())));
        }

        Collections.sort(list, (o1, o2) -> o1.num - o2.num);

        long cnt =0;

        for(int i=0; i<list.size(); i++){
            Node temp = list.get(i);
            cnt += query(temp.idx, N, 1, 1, N);
            update(temp.idx, 1, 1, 1, N);
        }
        System.out.println(cnt);
    }
    public static void update(int X, int V, int node, int S, int E){
        if(S==E){
            tree[node] = V;
            return;
        }
        int mid = (S+E)/2;

        if(X <= mid){
            update(X, V, 2*node, S, mid);
        }else{
            update(X, V, 2*node+1, mid+1, E);
        }
        tree[node] = tree[2*node]+tree[2*node+1];
    }
    public static long query(int L, int R, int node, int S, int E){
        // 범위 벗어날 경우
        if( R<S || E<L){
            return 0;
        }
        if(L<=S && E<=R){
            return tree[node];
        }
        int mid = (S+E)/2;
        return query(L, R, 2*node, S, mid)
                + query(L, R, 2*node+1, mid+1, E);
    }
}