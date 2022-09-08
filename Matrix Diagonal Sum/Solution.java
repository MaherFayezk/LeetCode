class Solution {
    public int diagonalSum(int[][] mat) {
        if(mat.length==0 || mat[0].length==0){
            return 0;
        }
        int sum=0;
        for(int i=0,j=mat.length-1;i<mat.length;i++,j--){
            sum+=mat[i][i];
            if(i!=j){
                sum+=mat[i][j];
            }
        }
        
        return sum;
    }
}