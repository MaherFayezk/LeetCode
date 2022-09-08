class Solution {
    
//TC O(n*m)
//SC O(1)
 public void setZeroes(int[][] matrix) {
        int rowsLen=matrix.length;
        int colsLen=matrix[0].length;
        boolean isCol=false;
        
         for(int i=0;i<rowsLen;i++){
             if(matrix[i][0]==0){
                    isCol=true;
            }
            for(int j=1;j<colsLen;j++){
                if(matrix[i][j]==0){
                    matrix[0][j]=0;
                    matrix[i][0]=0;
                }
            }
        }
         for(int i=1;i<rowsLen;i++){
            for(int j=1;j<colsLen;j++){
                if(matrix[0][j]==0 || matrix[i][0]==0){
                    matrix[i][j]=0;
                }
            }
        }
        if(matrix[0][0]==0){
             for(int i=0;i<colsLen;i++){
                matrix[0][i]=0;
            }
        }
        if(isCol){
            for(int i=0;i<rowsLen;i++){
                matrix[i][0]=0;
            }
        }
        
        
        
    }

//TC O(n*m)
//SC O(n+m)
public void setZeroes1(int[][] matrix) {
        int rowsLen=matrix.length;
        int colsLen=matrix[0].length;
        
        Set<Integer> rows=new HashSet();
        Set<Integer> cols=new HashSet();
        
        for(int i=0;i<rowsLen;i++){
            for(int j=0;j<colsLen;j++){
                if(matrix[i][j]==0){
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
         for(int i=0;i<rowsLen;i++){
            for(int j=0;j<colsLen;j++){
                if( rows.contains(i) ||cols.contains(j)){
                    matrix[i][j]=0;
                }
            }
        }
        
    }
}