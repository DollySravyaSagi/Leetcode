class Solution {
    public int scoreOfParentheses(String s) {
        int ans=0, c=0;
        for(int i=0;i<s.length();++i){
            if(s.charAt(i)=='('){
                c++;
            }else{
                c--;
                if(s.charAt(i-1)=='('){
                    ans+=1<<c;
                }
            }
        }
        return ans;
        
    }
}