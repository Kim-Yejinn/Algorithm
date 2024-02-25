import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<String> set = new HashSet<>();
        for(int i=0; i<N; i++){
            set.add(br.readLine());
        }

        TreeSet<String> tSet = new TreeSet<>();
        for(int i=0; i<M; i++){
            String str = br.readLine();

            if(set.contains(str)){
                tSet.add(str);
            }
        }

        StringBuilder sb = new StringBuilder();

        sb.append(tSet.size()).append("\n");

        for(String str : tSet){
            sb.append(str).append("\n");
        }
        System.out.println(sb);
    }
}