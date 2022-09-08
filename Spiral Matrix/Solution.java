class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
//TC O(n*m)
//SC O(1)
        List<Integer> res=new ArrayList();
        
        int rowIndex=0;
        int colIndex=0;
        int rowLimit=matrix.length-1;
        int colLimit=matrix[0].length-1;
        while(rowIndex<=rowLimit && colIndex<=colLimit){
             
            for(int i=colIndex;i<=colLimit;i++){
                res.add(matrix[rowIndex][i]);
            }
            for(int i=rowIndex+1;i<=rowLimit;i++){
                res.add(matrix[i][colLimit]);
            }
            if(rowIndex<rowLimit && colIndex<colLimit){
                for(int i=colLimit-1;i>=colIndex+1;i--){
                    res.add(matrix[rowLimit][i]);
                }
                for(int i=rowLimit;i>=rowIndex+1;i--){
                    res.add(matrix[i][colIndex]);
                }
            }
           rowIndex++; rowLimit--;colIndex++;colLimit--;
        }
        return res;
    }
}