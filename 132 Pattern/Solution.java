import java.util.Stack;

class Solution {
    public boolean find132pattern(int[] nums) {
        if(nums.length<3){
            return false;
        }
        int[] leftMin=new int[nums.length];
        Stack<Integer> rightStack= new Stack();
        int left,mid,right;
        
        leftMin[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            leftMin[i]=Math.min(leftMin[i-1], nums[i]);
        }
        
        for(int i=nums.length-1;i>0;i--){
            mid=nums[i];
            left=leftMin[i-1];
            
            if(mid>left){
                while(!rightStack.isEmpty() && rightStack.peek()<=left){
                    rightStack.pop();//pop as long as the potintial right is <=left 
                }
                if(!rightStack.isEmpty()&&rightStack.peek()<mid){
                    return true;//mid> left && right>left && right<mid
                }
            }
            rightStack.push(mid);//add potintial right 
        }
        
        
        return false;
        
        //TC O(n)
        //SC O(n)
    }
}