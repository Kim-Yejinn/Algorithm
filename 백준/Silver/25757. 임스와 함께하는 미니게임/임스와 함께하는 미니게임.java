import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        char op = st.nextToken().charAt(0);

        int num = 0;
        if(op == 'Y'){
            num = 1;
        }else if(op == 'F'){
            num = 2;
        }else{
            num = 3;
        }

        HashSet<String> set = new HashSet<>();

        for(int i=0; i<N; i++){
            set.add(br.readLine());
        }
        System.out.println(set.size()/num);
    }
}