import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] g;
    static int[] f;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        g = new int[100001];
        f = new int[100001];
        visit = new boolean[100001];

        for(int i=1; i<=100_000; i++){
            f[i] = findF(i);
            if(f[i] == i){
                g[i] = 1;
            }
        }

        int ans = 0;
        for(int i=L; i<=R; i++){
            ans += findG(i);
        }
        System.out.println(ans);
    }

    public static int findF(int num){
        int A = findA(num);
        int B = findB(num);

        int S = findSize(B);
        if(S == 1){
            S = 10;
        }
        return A*S + B;
    }

    public static int findG(int idx){
        if(g[idx] == 1){
            return 1;
        }
        if(g[idx] == -1){
            return -1;
        }
        if(f[idx] > 100000){
            return -1;
        }

        if(visit[idx]){
            return 0;
        }

        visit[idx] = true;

        int t = findG(f[idx]);

        if(t == 1){
            g[idx] = 1;
            return 1;
        }
        if(t == -1){
            g[idx] = -1;
            return -1;
        }
        return 0;

    }

    public static int findA(int num){
        int t = num;
        int ans = 0;
        while (t>0){
            ans += t%10;
            t /= 10;
        }
        return ans;
    }
    public static int findB(int num){
        int t = num;
        int ans = 1;
        while (t>0){
            ans *= t%10;
            t /= 10;
        }
        return ans;
    }
    public static int findSize(int num){
        int t = num;
        int ans = 1;

        while (t>0){
            t/=10;
            ans *= 10;
        }
        return ans;
    }
}