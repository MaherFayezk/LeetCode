import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result= new ArrayList();
        HashSet<Integer> numsSet=new HashSet();
       
        for(int num:nums){
            numsSet.add(num);
        }
        for(int i=1;i<=nums.length;i++){
            if(!numsSet.contains(i)){
                result.add(i);
            }
        }
        return result;
    }
  public List<Integer> findDisappearedNumbers2(int[] nums) {
        List<Integer> result= new ArrayList();
       
        for(int num:nums){
            int index=Math.abs(num)-1;
            nums[index]=Math.abs(nums[index])*-1;
        }
    
         for(int i=0;i<nums.length;i++){
            if(nums[i]>0){
                result.add(i+1);
            }
        }
    
        //TC O(n) 
        //SC O(1)
        //Map each element to its index and mark the value there to negatvive 
        //iterate over the array and get the index of the positive value 
        //those indexes there is no mapping to it
        return result;
    }
}