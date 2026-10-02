class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res=new ArrayList<String>();
        backtrack(res, "",0,0,n);
        return res;
    }
    public void backtrack(List<String> res, String currentStr, int c1, int c2, int max){
        if(currentStr.length()==max*2){
            res.add(currentStr);
            return;
        }
        if (c1<max) backtrack(res, currentStr+"(",c1+1,c2, max);
        if(c2<c1) backtrack(res, currentStr+")", c1, c2+1,max);
    }
}