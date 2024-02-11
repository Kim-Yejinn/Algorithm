import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String T = br.readLine();
        String P = br.readLine();

        if(T.length() < P.length()){
            System.out.println(0);
            return;
        }

        // 서로소이고 M은 소수로 하는 것이 해시 충돌 확률을 줄일 수 있다.
        // M은 보통 10억 정도..
        int C = 31;
        int M = 1_000_000_007;

        // P의 해시 함수 미리 구하자
        // T도 처음은 구해두자
        long ph = 0;
        long th = 0;
        long power = 1;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0; i<P.length(); i++){
            int t1 = P.charAt(P.length()-i-1);
            int t2 = T.charAt(P.length()-i-1);
            // 앞 부터 넣은 것이니..
            ph = (ph + t1 * power) % M;
            th = (th + t2 * power) % M;

            power = (power * C) % M;
        }
        if(th == ph){
            list.add(1);
        }

        // T를 돌면서 짜르는데 같은지 확인한다.
        for(int i=1; i<=T.length() - P.length(); i++){
            int t1 = T.charAt(i-1); // 지울 것
            int t2 = T.charAt(i+P.length()-1);
            // 곱하고
            th = (th * C) % M;
            // 맨앞을 지우고
            th = th + M - (t1 * power) % M;
            // 새로운 값 더한다.
            th += t2;

            th %= M;
            if(th == ph){
                // 찾으면
                list.add(i+1);
            }
        }
        System.out.println(list.size());
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<list.size(); i++){
            sb.append(list.get(i)).append(" ");
        }
        System.out.println(sb);

    }
}