import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static class Node{
        int num;
        int dis;

        Node(int num, int dis){
            this.num = num;
            this.dis = dis;
        }
    }
    static int N;
    static int H;

    static int min;
    static int max;

    static ArrayList<Node>[] list;

    static int[] depth;
    static int[][] par;
    static int[][] minDistance;
    static int[][] maxDistance;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        H = getHeight();


        depth = new int[N+1];
        par = new int[N+1][H];

        minDistance = new int[N+1][H];
        maxDistance = new int[N+1][H];

        list = new ArrayList[N+1];
        check = new boolean[N+1];

        for(int i=1; i<=N; i++){
            list[i] = new ArrayList<>();
        }

        StringTokenizer st = null;
        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
            check[b] = true;
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

        StringBuilder sb = new StringBuilder();
        int K = Integer.parseInt(br.readLine());
        for(int i=0; i<K; i++){
            st = new StringTokenizer(br.readLine());
            int D = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            min = Integer.MAX_VALUE;
            max = Integer.MIN_VALUE;

            LCA(D, E);
            sb.append(min+" "+max).append("\n");
        }
        System.out.println(sb);
    }
    public static int getHeight(){
        return (int) Math.ceil(Math.log(N)/Math.log(2))+1;
    }
    public static void init(int cur, int h, int parent){
        depth[cur] = h;
        for(int i=0; i<list[cur].size(); i++){
            int temp = list[cur].get(i).num;

            if(temp != parent){
                init(temp, h+1, cur);
                par[temp][0] = cur;
                minDistance[temp][0] = maxDistance[temp][0] = list[cur].get(i).dis;
            }
        }
    }
    public static void fillParent(){
        for(int i=1; i<H; i++){
            for(int j=1; j<=N; j++){
                par[j][i] = par[par[j][i-1]][i-1];
                minDistance[j][i] = Math.min(minDistance[j][i-1], minDistance[par[j][i-1]][i-1]);
                maxDistance[j][i] = Math.max(maxDistance[j][i-1], maxDistance[par[j][i-1]][i-1]);
            }
        }
    }
    public static void LCA(int a, int b){
        if(depth[a]<depth[b]){
            int t = a;
            a = b;
            b = t;
        }

        // 같은 높이까지 올리기
        for(int i=H-1; i>=0; i--){
            if(Math.pow(2, i) <= depth[a]-depth[b]){
                min = Math.min(min, minDistance[a][i]);
                max = Math.max(max, maxDistance[a][i]);
                a = par[a][i];
            }
        }

        if(a==b){
            return;
        }

        for(int i=H-1; i>=0; i--){
            if(par[a][i]!= par[b][i]){

                min = Math.min(min, minDistance[a][i]);
                max = Math.max(max, maxDistance[a][i]);
                min = Math.min(min, minDistance[b][i]);
                max = Math.max(max, maxDistance[b][i]);

                a = par[a][i];
                b = par[b][i];
            }
        }
        min = Math.min(min, minDistance[a][0]);
        max = Math.max(max, maxDistance[a][0]);
        min = Math.min(min, minDistance[b][0]);
        max = Math.max(max, maxDistance[b][0]);
    }
}