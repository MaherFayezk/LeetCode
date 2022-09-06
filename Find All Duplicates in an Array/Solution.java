import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> duplicates=new ArrayList();
        
        for(int i=0;i<nums.length;i++){
            int index=Math.abs(nums[i])-1;
            
            if(nums[index]<0){
                duplicates.add(index+1);
            }
            nums[index]=Math.abs(nums[index])*-1;
        }
        
        return duplicates;
    }
//TC O(n)
//SC O(1)
//See if the value gets mapped to the same index 
//If yes then it is repeated 

}