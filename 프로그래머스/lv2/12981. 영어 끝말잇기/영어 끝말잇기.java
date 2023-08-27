import java.util.Map;
import java.util.HashMap;
class Solution {
    public int[] solution(int n, String[] words) {

        Map<String, Integer> map=new HashMap<>();
        
        int[] answer = new int[2];
        
        int idx=0;
        int turn=0;
        s:while(idx < words.length-1){
            turn++;
            for(int i=1; i<=n; i++){
                if(idx!=0){
                    char[] last= words[idx-1].toCharArray();
                    char[] curr=words[idx].toCharArray();
                    if(last[last.length-1]!=curr[0]){
                         answer[1]=turn;
                        answer[0]=i;
                       break s;
                    }
                }
                if(map.containsKey(words[idx])){
                    answer[1]=turn;
                    answer[0]=i;
                    break s;
                }else{
                    map.put(words[idx],0);
                }
                idx++;
            }
        }
        
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다. 
       // System.out.println(answer);

        return answer;
    }
}