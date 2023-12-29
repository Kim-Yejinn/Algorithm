
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int N;
    static int M;
    static int K;
    static int[][] map;
    static int[][] arr;
    static int[][] temp;
    static int[][] ans;

    // 연산들 저장해 둘 배열
    static int[] R_list;
    static int[] C_list;
    static int[] S_list;

    static int[] select;
    static boolean[] visit;

    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();

        map = new int[N + 1][M + 1];
        arr = new int[N + 1][M + 1];

        R_list = new int[K];
        C_list = new int[K];
        S_list = new int[K];

        select = new int[K];
        visit = new boolean[K];

        answer = Integer.MAX_VALUE;

        // 입력
        for(int r=1; r<=N; r++){
            for(int c=1; c<=M; c++){
                map[r][c] = sc.nextInt();
            }
        }

        for (int t = 0; t < K; t++) {
            R_list[t] = sc.nextInt();
            C_list[t] = sc.nextInt();
            S_list[t] = sc.nextInt();
        }

        // 순서 정하기
        rec(0);
        
        // 답 출력
        System.out.println(answer);
    }

    public static void init(){
        // 맵 복사
        for(int r=1; r<=N; r++){
            for(int c=1; c<=M; c++){
                arr[r][c] = map[r][c];
            }
        }
    }
    public static void cal(){
        // 맵 초기화
        init();
        // 돌리기
        for(int i=0; i<K; i++){
            int num = select[i];
            start(R_list[num],C_list[num], S_list[num]);
        }

        // 계산
        int min = Integer.MAX_VALUE;
        for(int r=1; r<=N; r++){
            int sum =0;
            for(int c=1; c<=M;c++){
                sum+=arr[r][c];
            }
            if(sum<min){
                min=sum;
            }
        }
//        System.out.println(min);
        if(min<answer){
            answer = min;
        }
    }

    public static void rec(int num){
        if(num==K){
            // 다 골랐을 경우

//            System.out.println(Arrays.toString(select));
            cal();
            return;
        }

        for(int i=0; i<K; i++){
            if(visit[i]){
                continue;
            }
            visit[i] = true;
            select[num] = i;
            rec(num + 1);
            visit[i] = false;
        }

    }
    public static void start(int R, int C, int S){
        // 임시 배열 생성 및 복사
        int len = 2*S+1;
        temp = new int[len][len];
        ans = new int[len][len];

        int stR = 0;
        int stC = 0;

        for(int r=R-S; r<=R+S; r++){
            for(int c=C-S; c<=C+S; c++){
                temp[stR][stC] = arr[r][c];
                stC++;
            }
            stC=0;
            stR++;
        }
        cycle(len, S);
        paste(R,C,S);
    }

    public static void cycle(int len, int S){
        // 복사된 배열을 회전
        // 시계방향 회전 및 배열에 넣기
        for(int i=0; i<S; i++){
            // 시작 점 좌표는 (i, i)

            // 오른 len-i-1 까지
            for(int j=i+1; j<=len-i-1; j++) {
                ans[i][j] = temp[i][j-1];
            }
            // 아래 len-i-1 까지
            for(int j=i+1; j<=len-i-1; j++){
                ans[j][len-i-1] = temp[j-1][len-i-1];
            }

            // 왼 i까지
            for(int j=len-i-2; j>=i; j--){
                ans[len-i-1][j] = temp[len-i-1][j+1];
            }

            // 위 i까지
            for(int j=len-i-2; j>=i; j--){
                ans[j][i] = temp[j+1][i];
            }
        }
        // 중앙은 그대로 넣어주기
        ans[S][S] = temp[S][S];
    }

    public static void paste(int R, int C, int S){
        int stR = 0;
        int stC = 0;

        for(int r=R-S; r<=R+S; r++){
            for(int c=C-S; c<=C+S; c++){
                arr[r][c] = ans[stR][stC];
                stC++;
            }
            stC=0;
            stR++;
        }
    }

}