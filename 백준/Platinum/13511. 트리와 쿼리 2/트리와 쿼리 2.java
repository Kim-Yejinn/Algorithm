import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static class Node{
        int num;
        int w;
        Node(int num, int w){
            this.num = num;
            this.w = w;
        }
    }

    static int N;
    static int H;
    static int[] depth;
    static int[][] par;
    static long[] distance;
    static ArrayList<Node>[] list;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        H = getHeight();

        depth = new int[N+1];
        par = new int[N+1][H];
        distance = new long[N+1];

        list = new ArrayList[N+1];
        check = new boolean[N+1];

        for(int i=0; i<=N; i++){
            list[i] = new ArrayList<>();
        }
        StringTokenizer st = null;
        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[u].add(new Node(v, w));
            list[v].add(new Node(u, w));

            check[v] = true;
        }

        int root = 0;
        for(int i=1; i<=N; i++){
            if(!check[i]){
                root = i;
                break;
            }
        }

        init(root, 1, 0);
        fillParent();

        int M = Integer.parseInt(br.readLine());

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int op = Integer.parseInt(st.nextToken());

            if(op == 1){
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int com = LCA(u, v);
                long dis = distance[u]+distance[v]-2*distance[com];
                System.out.println(dis);
            }else{
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int k = Integer.parseInt(st.nextToken());

                int com = LCA(u,v);
                int num = fintK(u, v, com, k-1);
                System.out.println(num);
            }
        }


    }
    public static int getHeight(){
        return (int) Math.ceil(Math.log(N)/Math.log(2))+1;
    }
    public static void init(int cur, int h, int parent){
        depth[cur] = h;
        for(int i=0; i<list[cur].size(); i++){
            Node nxt = list[cur].get(i);
            if(nxt.num != parent){
                par[nxt.num][0] = cur;
                distance[nxt.num] = distance[cur] + nxt.w;
                init(nxt.num, h+1, cur);
            }
        }
    }
    public static void fillParent(){
        for(int i=1; i<H; i++){
            for(int j=1; j<N+1; j++){
                par[j][i] = par[par[j][i-1]][i-1];
            }
        }
    }
    public static int LCA(int a, int b){
        if(depth[a]<depth[b]){
            int t = a;
            a = b;
            b = t;
        }

        for(int i=H-1; i>=0; i--){
            if(Math.pow(2, i) <= depth[a]- depth[b]){
                a = par[a][i];
            }
        }
        if(a==b){
            return a;
        }

        for(int i=H-1; i>=0; i--){
            if(par[a][i] != par[b][i]){
                a = par[a][i];
                b = par[b][i];
            }
        }
        return par[a][0];
    }

    public static int fintK(int U, int V, int C, int K){
        int diff = depth[U] - depth[C];
        int diff2 = depth[V] - depth[C];
        int ans;
        if(diff >= K){
            ans = goParent(U, K);
        }else{
            int cal = diff2 + diff - K;
            ans = goParent(V, cal);
        }
        return ans;
    }
    public static int goParent(int start, int cal){
        int st = start;
        for(int i=H-1; i>=0; i--){
            if((cal & (1<<i)) >0){
                st = par[st][i];
            }
        }
        return st;
    }
}