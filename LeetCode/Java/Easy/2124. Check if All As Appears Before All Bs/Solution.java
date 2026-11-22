class Solution {
    public boolean checkString(String s) {
        boolean fb=false;
        for(char i:s.toCharArray()){
            if(i=='a'&&fb) return false;
            else if(i=='b') fb=true;
        }
        return true;
    }
}