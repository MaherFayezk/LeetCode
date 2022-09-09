class Solution {
//Using Auxoly matrix to keep track of visited
//O(n*m)
//O(m*n)
    public int numIslands(char[][] grid) {
        int rows=grid.length;
        
        if(rows==0){
            return 0;
        }
        int cols=grid[0].length;
        int numbOfIslands=0;
        boolean [][] auMat=new boolean[rows][cols];
        
        for (int i=0; i<rows;i++){
            for(int j=0; j<cols;j++){
                if(grid[i][j]=='1' && auMat[i][j]==false){
                    markConnectedIsland(grid,auMat,i,j,rows,cols);
                    numbOfIslands++;
                }
            }
        }
        
        return numbOfIslands;
    }
    private void markConnectedIsland(char[][] grid, boolean[][]auMat, int i,int j,int rows,int cols){
        if(i<0 || j<0||i>=rows||j>=cols || grid[i][j]=='0'){
            return;
        }
        if(auMat[i][j]==true){
            return;
        }
        auMat[i][j]=true;
         markConnectedIsland(grid,auMat,i+1,j,rows,cols);
         markConnectedIsland(grid,auMat,i-1,j,rows,cols);
         markConnectedIsland(grid,auMat,i,j+1,rows,cols);
         markConnectedIsland(grid,auMat,i,j-1,rows,cols);
    }
    
}