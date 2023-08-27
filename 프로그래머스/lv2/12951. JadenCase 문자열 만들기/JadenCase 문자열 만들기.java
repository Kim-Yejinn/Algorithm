class Solution {
    public String solution(String s) {
        String answer = "";
        String temp="";
        for(int i=0; i<s.length(); i++){
            char t=s.charAt(i);
            
            if(t==' '){
                temp+=" ";
                temp=temp.toLowerCase();
                answer+=temp.substring(0,1).toUpperCase()+temp.substring(1,temp.length());             
                temp="";
            }else{
                temp+=t;
            }
            if(i==s.length()-1&& temp.length()!=0){
                temp=temp.toLowerCase();
                answer+=temp.substring(0,1).toUpperCase()+temp.substring(1,temp.length());         
            } 
        }
        

        return answer;
    }
}