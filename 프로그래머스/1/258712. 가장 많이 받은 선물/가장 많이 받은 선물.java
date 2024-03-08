import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        Map<String, Integer> giftCnt = new HashMap<>();
        Map<String, Integer> giftScore = new HashMap<>();
        
        for(int i=0; i<friends.length; i++){
            giftCnt.put(friends[i], 0);
        }
        
        for(int i=0; i<gifts.length; i++){
            if(!giftScore.containsKey(gifts[i])){
                giftScore.put(gifts[i], 0);
            }
            giftScore.put(gifts[i], giftScore.get(gifts[i])+1);
            
            StringTokenizer st = new StringTokenizer(gifts[i]);
            String sender = st.nextToken();
            String receiver = st.nextToken();
            
            giftCnt.put(sender, giftCnt.get(sender)+1);
            giftCnt.put(receiver, giftCnt.get(receiver)-1);
        }
        
        int[] ans = new int[friends.length];
        
        for(int i=0; i<friends.length; i++){
            for(int j=i+1; j<friends.length; j++){
                String str = friends[i]+" "+ friends[j];
                String str2 = friends[j]+" " + friends[i];
                
                int a = -1;
                int b = -1;
                if(giftScore.containsKey(str)){
                    a = giftScore.get(str);
                }
                if(giftScore.containsKey(str2)){
                    b = giftScore.get(str2);
                }
                
                if(a > b){
                    ans[i]++;
                }else if (a < b){
                    ans[j]++;
                }else{
                    int aScore = giftCnt.get(friends[i]);
                    int bScore = giftCnt.get(friends[j]);
                    
                    if(aScore > bScore){
                        ans[i]++;
                    }else if(aScore < bScore){
                        ans[j]++;
                    }
                }
            }
        }

        int answer = 0;
        for(int i=0; i<friends.length; i++){
            if(answer < ans[i]){
                answer = ans[i];
            }
        }
        
        return answer;
    }
}