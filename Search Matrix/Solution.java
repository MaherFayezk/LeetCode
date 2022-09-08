class Solution {
//TC O(n)+O(m)
//SC O(1)
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length==0|| matrix[0].length==0){
            return false;
        }
        int i=0;
        int rowLen=matrix[0].length;
        for(; i<matrix.length;i++){
            if(target<=matrix[i][rowLen-1]){
                break;
            }
        }
        if(i>=matrix.length){
            return false;
        }
        for(int j=0;j<rowLen;j++){
            if(target==matrix[i][j]){
                return true;
            }
        }
        return false;
    }
 public boolean searchMatrix2(int[][] matrix, int target) {
//TC O(log(n*m))
//SC O(1)
        if(matrix.length==0|| matrix[0].length==0){
            return false;
        }
        int rows=matrix.length;
        int cols=matrix[0].length;
        int start=0;
        int end=rows*cols-1;
        while(start<=end){
            int mid=(start+end)/2;
            if(target==matrix[mid/cols][mid%cols]){
                return true;
            }else if(target>matrix[mid/cols][mid%cols]){
                start=mid+1;
            }else {
                end=mid-1;
            }
        }
        return false;
    }
}