import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int H;
    static ArrayList<Integer>[] list;
    static int[][] ancestor; // 연결된 조상..
    static int[] depth; // 해당 노드의 깊이

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        // 1번부터 노드를 저장
        list = new ArrayList[N+1];

        for(int i=1; i<=N; i++){
            list[i] = new ArrayList<>();
        }

        StringTokenizer st = null;
        for(int i=1; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        H = getTreeHeight();
        depth = new int[N+1];
        ancestor = new int[N+1][H];

        init(1,1,0);
        fillParent();

        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(LCA(a,b)).append("\n");
        }
        System.out.println(sb);

    }

    public static int getTreeHeight(){
        // 최대 크기
        // 1부터 시작하기 때문에 +1
        return (int)Math.ceil(Math.log(N)/Math.log(2)) +1;
    }

    public static void init(int cur, int h, int parent){
        // dfs를 이용해서 각 노드의 높이와 첫번째 부모 노드로 초기화 한다.
        // cur : 지금 값, h : 지금 depth, parent는 이전 노드
        depth[cur] = h; //depth를 넣어줌
        for(int i=0; i<list[cur].size(); i++){
            int temp = list[cur].get(i);
            if(temp != parent){
                init(temp, h+1, cur);
                ancestor[temp][0] = cur;
            }
        }
    }

    public static void fillParent(){
        for(int i=1; i<H; i++){
            for(int j=1; j<N+1; j++){
                ancestor[j][i] = ancestor[ancestor[j][i-1]][i-1];
            }
        }
    }

    public static int LCA(int a, int b){
        int ah = depth[a];
        int bh = depth[b];

        if(ah < bh){
            int t = a;
            a = b;
            b = t;
        }

        for (int i=H-1; i>=0; i--) {
            if(Math.pow(2, i) <= depth[a] - depth[b]){
                a = ancestor[a][i];
            }
        }
        if(a==b) return a;

        for(int i=H-1; i>=0; i--){
            if(ancestor[a][i]!=ancestor[b][i]){
                a = ancestor[a][i];
                b = ancestor[b][i];
            }
        }
        return ancestor[a][0];


    }





}