import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class Node{
        int r;
        int c;
        Node(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

    static int N;
    static boolean ans;
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};

    static char[][] arr;
    static boolean[][] check;
    static List<Node> teacher;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new char[N][N];
        check = new boolean[N][N];
        ans = false;
        teacher = new ArrayList<>();

        for(int r=0; r<N; r++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int c=0; c<N; c++){
                arr[r][c] = st.nextToken().charAt(0);

                if(arr[r][c] == 'T'){
                    teacher.add(new Node(r, c));
                }
            }
        }

        rec(0,0,0);

        if(ans){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
    public static void rec(int cnt, int lr, int lc){

        if(ans){
            return;
        }

        if(cnt == 3){
            if(find()){
                ans = true;
            }
            return;
        }


        for(int r=lr; r<N; r++){
            for(int c=0; c<N; c++){
                if(r == lr && c==0){
                    c = lc;
                }

                if(arr[r][c] != 'X'){
                    continue;
                }
                arr[r][c] = 'O';
                rec(cnt+1, r, c);
                arr[r][c] = 'X';
                if(ans){
                    return;
                }
            }
            if(ans){
                return;
            }
        }
    }

    public static boolean find(){

        for(int j=0; j<teacher.size(); j++){
            Node temp = teacher.get(j);

            for(int i=0; i<4; i++){
                for(int d=1; d<N; d++){
                    int nr = temp.r + dr[i] * d;
                    int nc = temp.c + dc[i] * d;

                    if(nr<0||nc<0||nr>=N||nc>=N){
                        break;
                    }
                    if(arr[nr][nc] == 'O'){
                        break;
                    }
                    if(arr[nr][nc] == 'S'){
                        return false;
                    }
                }
            }
        }

        return true;
    }
}