class Solution {
    //TC O(n^2)
    //SC O(1)
    public void rotate(int[][] matrix) {
        filpDiagonaly(matrix);
        flipHorizontaly(matrix);
    }
    private void filpDiagonaly(int[][]matrix){
        int len=matrix.length;
        for(int i=0;i<len-1;i++){
            for(int j=0; j<len-i-1;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[len-j-1][len-i-1];
                matrix[len-j-1][len-i-1]=temp;
            }
        }
    }
    private void flipHorizontaly(int[][]matrix){
        int len=matrix.length;
        for(int i=0;i<len/2;i++){
            for(int j=0;j<len;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[len-i-1][j];
                matrix[len-i-1][j]=temp;
            }
        }
    }
}