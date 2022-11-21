class Solution {
    public int minDistance(String word1, String word2) {
        char[] str1=word1.toCharArray();
        char[] str2=word2.toCharArray();
        int str1Len=str1.length;
        int str2Len=str2.length;
        int dp[][]=new int[str1Len+1][str2Len+1];
        
        for(int col=0;col<=str2Len; col++){
            dp[0][col]=col;
        }
        for(int row=0;row<=str1Len; row++){
            dp[row][0]=row;
        }
        
        for(int row=1;row<=str1Len; row++){
            for(int col=1;col<=str2Len; col++){
                if(str1[row-1]==str2[col-1]){
                    dp[row][col]=dp[row-1][col-1];
                }else {
                    dp[row][col]=Math.min(Math.min(dp[row][col-1],dp[row-1][col]),dp[row-1][col-1])+1;
                }
            }
        }
        
        return dp[str1Len][str2Len];
    }
}// O(mn) TC && SC