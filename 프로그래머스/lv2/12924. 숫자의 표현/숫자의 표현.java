class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int temp=0;
        for(int i=1; i<=n ; i++){
            if(temp>=n){
                break;
            }
            
            if((n-temp)%i==0){
                answer++;
            }
            
            temp+=i;
        }
        
        return answer;
    }
}