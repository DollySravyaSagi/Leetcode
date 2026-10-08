class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb=new StringBuilder();
        int l=0;
        for(char c: s.toCharArray()){
            if(c==')') l--;
            if(l>0) sb.append(c);
            if(c=='(') l++;
        }
        return sb.toString();
    }
}