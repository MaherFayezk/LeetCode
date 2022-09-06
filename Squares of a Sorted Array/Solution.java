import java.util.Stack;

class Solution {

 public int[] sortedSquares(int[] nums) {
        int[] squares=new int[nums.length];
       int len=nums.length;
        int left=0,right=len-1;
        for(int i=len-1; i>=0 ;i--){
            int leftSquare=(int)Math.pow(nums[left],2);
            int rightSquare=(int)Math.pow(nums[right],2);
            if(leftSquare>rightSquare){
                squares[i]=leftSquare;
                left++;
            }
            else {
                squares[i]=rightSquare;
                right--;
            }
        }
        return squares;
    }




    public int[] sortedSquares2(int[] nums) {
        int[] squares=new int[nums.length];
        Stack<Integer> negatives=new Stack();
       
        for(int num:nums){
            if(num<0){
                negatives.push(Math.abs(num));
            }
        }
        int index=0;
        for(int num:nums){
            if(num>=0){
                while(!negatives.isEmpty()&&negatives.peek()<=num){
                    squares[index]=(int)Math.pow(negatives.pop(),2);
                    index++;
                }
                squares[index]=(int)Math.pow(num,2);
                index++;  
            }
            
        }
        
        while(!negatives.isEmpty()){
            squares[index]=(int)Math.pow(negatives.pop(),2);
            index++;
        }
        return squares;
    }
}