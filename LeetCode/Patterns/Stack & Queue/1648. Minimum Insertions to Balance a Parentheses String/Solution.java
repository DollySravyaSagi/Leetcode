class Solution {
    public int minInsertions(String s) {
        int l=s.length();
        int add=0, left=0, idx=0;
        while(idx<l){
            if(s.charAt(idx)=='('){
                left++; idx++;
            }else{
                if(left>0) left--;
                else add++;
                if(idx<l-1 && s.charAt(idx+1)==')') idx+=2;
                else {
                    add++;
                    idx++;
                }
            }
        }
        add+=left*2;
        return add;
    }
}