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

    static ArrayList<Node>[] list;

    static int N;
    static int H;
    static int[] depth;
    static int[][] par;
    static int[] distance; // 1번부터의 거리

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        list = new ArrayList[N+1];

        H = getHeight();
        depth = new int[N+1];
        par = new int[N+1][H];
        distance = new int[N+1];

        for(int i=0; i<=N; i++){
            list[i] = new ArrayList<>();
        }

        StringTokenizer st = null;
        for(int i=0; i<N-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int dis = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, dis));
            list[b].add(new Node(a, dis));
        }

        init(1, 1, 0);
        fillParent();

        StringBuilder sb = new StringBuilder();

        int M = Integer.parseInt(br.readLine());
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // 1에서 a, b까지 구한다음 공통(LCA까지 거리)를 빼준다
            sb.append(distance[a]+distance[b]- 2* distance[LCA(a, b)]).append("\n");
        }
        System.out.println(sb);

    }
    public static int getHeight(){
        return (int)(Math.ceil(Math.log(N))/Math.log(2)+1);
    }

    public static void init(int cur, int h, int parent){
        // init
        // dfs로 넣어 주어야 함.
        // 노드 깊이와 첫번째는 부모로 다 넣어주어야 함.

        // 높이
        depth[cur] = h;

        for(int i=0; i<list[cur].size(); i++){
            // 연결된 것을 돌면서 값을 바꾸어 준다!
            int temp = list[cur].get(i).num;
            // 양방향으로 연결되어 있기 때문에 부모가 아니라는 가정이 들어가야 한다.
            if(temp != parent){
                distance[temp] = distance[cur]+list[cur].get(i).dis;
                init(temp, h+1, cur);
                // 다음 갈 것의 1번 전의 것은 cur이기 때문
                par[temp][0] = cur;
            }
        }
    }

    public static void fillParent(){
        // 현재의 부모의 부모의 부모.. 를 찾는 점화식은
        // par[a][b] = par[이전 부모][b-1] -> par[par[a][b-1]][b-1]
        // j의 2^i 번째 조상
        for(int i=1; i<H; i++){
            for(int j=1; j<N+1; j++){
                par[j][i] = par[par[j][i-1]][i-1];
            }
        }
    }

    public static int LCA(int a, int b){
        // a가 더 커야 한다.
        if(depth[a]<depth[b]){
            int t = a;
            a = b;
            b = t;
        }

        // 깊이가 같아질때 까지 올라가야 된다
        // 큰 점프부터 처리하는 것이 더 빠름
        for(int i=H-1; i>=0; i--){
            if(Math.pow(2, i) <= depth[a] - depth[b]){
                a = par[a][i];
            }
        }
        // 깊이가 같아졌는데 b랑 같을 경우(b가 a의 조상일 경우)
        if(a == b){
            return a;
        }

        // 한층씩 올라가면서 조상이 같은지 확인해야 함.
        for(int i=H-1; i>=0; i--){
            // 이전 조상이 다르면 올라가고 (아직 ㄴㄴ라는 소리)
            // 같으면 그냥 continue;
            if(par[a][i] != par[b][i]){
                a = par[a][i];
                b = par[b][i];
            }
        }
        // 마지막
        return par[a][0];


    }
}