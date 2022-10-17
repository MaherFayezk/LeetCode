class Solution {
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
      
        int[][]dp=new int[m][n];
        dp[0][0]=grid[0][0];
        for(int i=1;i<m; i++){
            dp[i][0]=dp[i-1][0]+grid[i][0];
        }
         for(int i=1;i<n; i++){
            dp[0][i]=dp[0][i-1]+grid[0][i];
        }
        
        for(int row=1;row<m;row++){
            for(int col=1; col<n;col++){
                dp[row][col]=grid[row][col]+Math.min(dp[row-1][col],dp[row][col-1]);
            }
        }
        
        return dp[m-1][n-1];
    }
} //TC & SC O(mn)