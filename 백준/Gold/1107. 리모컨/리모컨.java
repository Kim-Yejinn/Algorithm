import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static boolean[] button;
    static int min;
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        button = new boolean[10];
        Arrays.fill(button, true);

        N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        StringTokenizer st = null;
        if(M > 0){
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<M; i++){
                int btn = Integer.parseInt(st.nextToken());
                button[btn] = false;
            }
        }

        min = Integer.MAX_VALUE;

        // 초기 값
        min = Math.abs(N - 100);
        makeNum(0, 0);
        System.out.println(min);
    }

    public static void makeNum(int num, int cur){
        if(num > 7){
            return;
        }
        if(num > 0){
            int t = Math.abs(N - cur) + num;
            min = Math.min(min, t);
        }

        for(int i=0; i<10; i++){
            if(button[i]){
                makeNum(num+1, cur*10+i);
            }
        }
    }
}