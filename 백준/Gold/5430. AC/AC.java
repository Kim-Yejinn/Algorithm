
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc =0; tc<T; tc++){
            String op = br.readLine();

            int n = Integer.parseInt(br.readLine());

            String str = br.readLine();
            String[] num = str.substring(1, str.length()-1).split(",");

            Deque<Integer> dq = new ArrayDeque<>();
            boolean flag = true;

            for(int i=0; i<n; i++){
                dq.addFirst(Integer.parseInt(num[i]));
            }

            boolean check = false;
            for(int i=0; i<op.length(); i++){
                char t = op.charAt(i);
                if(t=='R'){
                    flag = !flag;
                }else{
                    if(flag){
                        if(dq.isEmpty()){
                            check = true;
                            break;
                        }else{
                            // 앞에서 하기
                            dq.removeLast();
                        }
                    }else{
                        if(dq.isEmpty()){
                            check = true;
                            break;
                        }else{
                            // 뒤에서 하기
                            dq.removeFirst();
                        }
                    }
                }
            }

            if(check){
                System.out.println("error");
            }else{
                StringBuilder sb = new StringBuilder();
                sb.append("[");
                while(!dq.isEmpty()){

                    if(flag){
                        sb.append(dq.removeLast());
                    }else{
                        sb.append(dq.removeFirst());
                    }
                    if(!dq.isEmpty()){
                        sb.append(",");
                    }
                }
                sb.append("]");
                System.out.println(sb);
            }
        }
    }
}
