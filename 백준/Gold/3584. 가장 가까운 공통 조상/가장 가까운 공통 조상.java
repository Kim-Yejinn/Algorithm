import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int H;

    static ArrayList<Integer>[] list;
    static int[] depth;
    static int[][] par;
    static boolean[] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc=0; tc<T; tc++){
            N = Integer.parseInt(br.readLine());

            H = getHeight();
            depth = new int[N+1];
            par = new int[N+1][H];
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

                list[a].add(b);
                list[b].add(a);
                check[b] = true;
            }

            int root =0;
            for(int i=1; i<N; i++){
                if(!check[i]){
                    root = i;
                }
            }


            init(root, 1, 0);
            fillParent();

            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            System.out.println(LCA(a, b));
        }
    }
    public static int getHeight(){
        return (int) Math.ceil(Math.log(N)/Math.log(2))+1;
    }

    public static void init(int cur, int h, int parent){
        // 돌면서 depth랑 바로위 조상 저장해 둬야 함.
        depth[cur] = h;

        for(int i=0; i<list[cur].size(); i++){
            int temp = list[cur].get(i);

            if(temp != parent){
                init(temp, h+1, cur);
                par[temp][0] = cur;
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
        // a가 더 깊어야 함.
        if(depth[a]<depth[b]){
            int t = a;
            a = b;
            b = t;
        }

        // 같은 깊이까지 올려야 됨
        for(int i=H-1; i>=0; i--){
            if(Math.pow(2, i) <= depth[a]-depth[b]){
                a = par[a][i];
            }
        }

        // b가 a의 조상이었다면?
        if(a==b){
            return a;
        }
        // 계속 올라 가야 함
        for(int i=H-1; i>=0; i--){
            if(par[a][i] != par[b][i]){
                a = par[a][i];
                b = par[b][i];
            }
        }

        return par[a][0];
    }
}