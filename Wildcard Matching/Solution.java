class Solution {
    public boolean isMatch(String s, String p) {
        if(p.equals("*")){
            return true;
        }
        int sLen=s.length();
        int pLen=p.length();
        boolean [][] dp=new boolean[sLen+1][pLen+1];
        dp[0][0]=true;

        for(int col=1; col<=pLen;col++){
            if(p.charAt(col-1)=='*') {
                dp[0][col]=dp[0][col-1];
            }
        }
        
         for(int row=1;row<=sLen;row++){
             for(int col=1;col<=pLen;col++){
                 if(s.charAt(row-1)==p.charAt(col-1) || p.charAt(col-1)=='?'){
                     dp[row][col]=dp[row-1][col-1];
                 }else if(p.charAt(col-1)=='*'){
                     dp[row][col]=dp[row][col-1]||dp[row-1][col];
                 }else {
                     dp[row][col]=false;
                 }
             }
        }
        return dp[sLen][pLen];
    }
}