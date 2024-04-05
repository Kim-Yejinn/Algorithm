import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] arr;

    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};

    static int[][] friend;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N+1][N+1];
        friend = new int[N*N+1][4];

        StringTokenizer st;
        for(int i=1; i<=N*N; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());

            for(int j=0; j<4; j++){
                friend[num][j] = Integer.parseInt(st.nextToken());
            }

            int[] res = find(num);
            arr[res[0]][res[1]] = num;
        }

        System.out.println(getScore());
    }

    private static int getScore() {
        int score = 0;

        for(int r=1; r<=N; r++){
            for(int c=1; c<=N; c++){
                int cnt = 0;

                for(int i=0; i<4; i++){
                    int nr = r + dr[i];
                    int nc = c + dc[i];

                    if(nr<=0 || nc<=0 || nr>N || nc>N){
                        continue;
                    }

                    for(int j=0; j<4; j++){
                        if(arr[nr][nc] == friend[arr[r][c]][j]){
                            cnt++;
                            break;
                        }
                    }
                }

                if(cnt == 1){
                    score += 1;
                }else if(cnt == 2){
                    score += 10;
                }else if(cnt == 3){
                    score += 100;
                }else if(cnt == 4){
                    score += 1000;
                }
            }
        }
        return score;
    }

    public static int[] find(int num){
        int ansR = 0;
        int ansC = 0;

        int lastFriend = 0;
        int lastEmpty = -1;

        for(int r=1; r<=N; r++){
            for(int c=1; c<=N; c++){
                if(arr[r][c] != 0){
                    continue;
                }
                int friendCnt = 0;
                int emptyCnt = 0;

                for(int j=0; j<4; j++){
                    int nr = r + dr[j];
                    int nc = c + dc[j];

                    if(nr<=0 || nc<=0 || nr>N || nc>N){
                        continue;
                    }

                    if(arr[nr][nc] == 0){
                        emptyCnt++;
                        continue;
                    }

                    for(int k=0; k<4; k++){
                        if(arr[nr][nc] == friend[num][k]){
                            friendCnt++;
                            break;
                        }
                    }
                }

                if(friendCnt > lastFriend){
                    ansR = r;
                    ansC = c;
                    lastFriend = friendCnt;
                    lastEmpty = emptyCnt;
                }else if(friendCnt == lastFriend){
                    if(lastEmpty < emptyCnt){
                        ansR = r;
                        ansC = c;
                        lastEmpty = emptyCnt;
                    }
                }
            }
        }
        return new int[]{ansR, ansC};
    }
}