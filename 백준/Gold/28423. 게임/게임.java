import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int ans = 0;
        for(int i=L; i<=R; i++){
            ans += findG(i);
        }
        System.out.println(ans);
    }

    public static int findG(int num){
        int temp = num;
        boolean[] check = new boolean[100_001];

        while (temp > 0){
            int A = findA(temp);
            int B = findB(temp);

            int S = findSize(B);
            if(S == 1){
                S = 10;
            }
            int cal = A*S + B;

            if(cal > 100_000){
                return -1;
            }
            if(cal == temp){
                return 1;
            }
            if(check[cal]){
                return 0;
            }
            check[cal] = true;
            temp = cal;
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