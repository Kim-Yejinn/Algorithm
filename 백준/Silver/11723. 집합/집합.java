import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());
        HashSet<Integer> set = new HashSet<>();

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());

            String op = st.nextToken();

            if(op.equals("add")){
                int num = Integer.parseInt(st.nextToken());
                set.add(num);
            }else if(op.equals("remove")){
                int num = Integer.parseInt(st.nextToken());
                set.remove(num);
            }else if(op.equals("check")){
                int num = Integer.parseInt(st.nextToken());
                if(set.contains(num)){
                    sb.append("1").append("\n");
                }else{
                    sb.append("0").append("\n");
                }
            }else if(op.equals("toggle")){
                int num = Integer.parseInt(st.nextToken());
                if(set.contains(num)){
                    set.remove(num);
                }else{
                    set.add(num);
                }
            }else if(op.equals("all")){
                for(int j=1; j<=20; j++){
                    set.add(j);
                }
            }else{
                set.clear();
            }
        }
        System.out.println(sb);

    }
}