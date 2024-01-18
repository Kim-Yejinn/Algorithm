import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int[] left;
    static char[] root;
    static int[] right;
    static String ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = 10;

        for(int tc=1; tc<=T; tc++){
            int N = Integer.parseInt(br.readLine());
            ans = "";
            left = new int[N+1];
            root = new char[N+1];
            right = new int[N+1];

            for(int i=0; i<N; i++){
                StringTokenizer st = new StringTokenizer(br.readLine());

                int num = Integer.parseInt(st.nextToken());
                char temp = st.nextToken().charAt(0);

                root[num] = temp;

                if(st.hasMoreTokens()){
                    left[num] = Integer.parseInt(st.nextToken());
                }
                if(st.hasMoreTokens()){
                    right[num] = Integer.parseInt(st.nextToken());
                }
            }
            rec(1);
            System.out.println("#"+tc+" "+ans);
        }
    }
    public static void rec(int num){

        // L
        if(left[num]!=0){
            rec(left[num]);
        }

        // root
        ans+=root[num];

        // R
        if(right[num]!=0){
            rec(right[num]);
        }
    }
}