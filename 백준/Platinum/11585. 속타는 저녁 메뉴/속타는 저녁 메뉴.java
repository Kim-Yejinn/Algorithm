import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] pi;
    static char[] str;
    static char[] text;
    static int N;
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        str = new char[2*N];
        text = new char[N];
        pi = new int[N];
        cnt = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            str[i] = str[N+i] = st.nextToken().charAt(0);
        }
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            text[i] = st.nextToken().charAt(0);
        }
        kmp();
        int div = gcd(N, cnt);
        System.out.println(cnt/div+"/"+N/div);

    }

    public static int gcd(int a, int b){
        if(b==0) return a;
        return gcd(b, a%b);
    }

    public static void getPi(){
        int j = 0;

        for(int i=1; i<N; i++){
            while(j>0 && text[i] != text[j]){
                j = pi[j-1];
            }
            if(text[i] == text[j]){
                j++;
            }
            pi[i] = j;
        }
    }
    public static void kmp(){
        getPi();
        int j = 0;

        for(int i=0; i<N+N-1; i++){
            while (j>0 && str[i] != text[j]){
                j = pi[j-1];
            }
            if(str[i] == text[j]){
                if(j==N-1){
                    cnt++;
                    j = pi[j];
                }else{
                    j++;
                }
            }
        }
    }
}