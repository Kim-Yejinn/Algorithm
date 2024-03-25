import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        String[] day = today.split("[.]");
        // 기준이 되는 오늘 날짜
        int todayNum = Integer.parseInt(day[0])*28*12 + Integer.parseInt(day[1]) *28 + Integer.parseInt(day[2]) ;
    
        int[] delay = new int[26];
        
        for(int i=0; i<terms.length; i++){
            String[] temp = terms[i].split(" ");
            int m = temp[0].charAt(0)-'A';
            int d = Integer.parseInt(temp[1]);
            delay[m] = d*28;
        }
        
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<privacies.length; i++){
            String[] str = privacies[i].split(" ");
            String[] temp = str[0].split("[.]");
            int cal = Integer.parseInt(temp[0])*28*12 + Integer.parseInt(temp[1])*28 + Integer.parseInt(temp[2]);
            int m = str[1].charAt(0)-'A';
            
            cal += delay[m];
            
            if(todayNum >= cal){
                list.add(i+1);
            }
        }
        
        int[] answer = new int[list.size()];
        
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }

       return answer;
    
    }
}