import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N;
    static int time;

    static int[][] arr;
    static int[][] A;
    static PriorityQueue<Node> list;
    static Queue<Node> dead;
    static int[] dr = {1, 0, -1, 0, 1, 1, -1, -1};
    static int[] dc = {0, 1, 0, -1, 1, -1, 1, -1};

    public static class Node{
        int r;
        int c;
        int age;
        Node(int r, int c, int age){
            this.r = r;
            this.c = c;
            this.age = age;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        time = 0;

        arr = new int[N+1][N+1];
        A = new int[N+1][N+1];

        list = new PriorityQueue<>((o1, o2) -> o1.age - o2.age);
        dead = new LinkedList<>();

        for(int r=1; r<=N; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=1; c<=N; c++){
                arr[r][c] = 5;
                A[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            list.add(new Node(x, y, z));
        }

        for(int i=1; i<=K; i++){
            // 봄
            spring();
            // 여름
            summer();
            // 가을 
            fall();
            // 겨울
            winter();
        }
        System.out.println(cnt());
    }

    public static int cnt(){
        return list.size();
    }
    public static void spring(){
        List<Node> t = new ArrayList<>();
        while(!list.isEmpty()){
            Node temp = list.poll();

            if(arr[temp.r][temp.c] + time* A[temp.r][temp.c] >= temp.age){
                arr[temp.r][temp.c] -= temp.age;
                temp.age++;
                t.add(temp);
            }else{
                dead.add(temp);
            }
        }
        list.addAll(t);
    }
    public static void summer(){
        while (!dead.isEmpty()){
            Node temp = dead.poll();
            arr[temp.r][temp.c] += temp.age/2;
        }
    }
    public static void fall(){
        List<Node> t = new ArrayList<>();
        while (!list.isEmpty()){
            Node temp = list.poll();
            t.add(temp);
            if(temp.age % 5 == 0){
                for(int j=0; j<8; j++){
                    int nr = temp.r + dr[j];
                    int nc = temp.c + dc[j];

                    if(nr<1|| nc<1 || nr>N || nc>N){
                        continue;
                    }
                    t.add(new Node(nr, nc, 1));
                }
            }
        }
        list.addAll(t);
    }
    public static void winter(){
        // 양분 추가
        time++;
    }
}