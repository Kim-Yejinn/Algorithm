import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        String f_str = br.readLine();
        int[] first_cnt = new int[26];

        for(int i=0; i<f_str.length(); i++){
            first_cnt[f_str.charAt(i)-'A']++;
        }

        for(int i=1 ;i<N; i++){
            String str = br.readLine();
            int[] second_cnt = new int[26];

            for(int j=0; j<str.length(); j++){
                second_cnt[str.charAt(j)-'A']++;
            }

            int check1= 0;
            int check2 = 0;
            for(int j=0; j<26; j++){
                if(first_cnt[j]!=second_cnt[j]){
                    check1 += Math.abs(first_cnt[j] - second_cnt[j]);
                    check2 += first_cnt[j] - second_cnt[j];
                }
            }
            if(check1 <= 1 || (check1 == 2 && check2 == 0)){ // 하나 더하거나 빼는 경우
                answer++;
            }
        }
        System.out.println(answer);
    }
}
