class Solution {
    public int solution(int n) {
        //start : 16:40
        //finish : 16 : 57
        
        int cnt = check(n); 
        for(int i=n+1; i<=1000000; i++){
            if(cnt == check(i)){
                return i;
            }
        }
        return 0;
    }
    
    public static int check(int num){
        String input = Integer.toBinaryString(num);      

        int one = 0;
        
        for(int i=input.length()-1; i>=0; i--){
            char temp = input.charAt(i);
            if(temp == '1'){
                one++;
            }
        }
        return one;
    }
}