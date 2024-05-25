import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int pack = 1010;
        int price = 1010;

        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            pack = Math.min(pack, a);
            price = Math.min(price, b);
        }

        int c1 = price * N;
        int c2 = (N/6) * pack + (N - (N/6) * 6) * price;
        int c3 = (N/6+1) * pack;
        System.out.println(Math.min(c1, Math.min(c2, c3)));
    }
}