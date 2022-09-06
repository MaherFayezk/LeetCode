class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length()==0 ){
            return true;
        }
        for(int i=0,j=0;i<t.length();i++){
            if(s.charAt(j)==t.charAt(i)){
                j++;
            }
            if(j==s.length() && j>0){
                return true;
            }
        }
        return false;
    }
}