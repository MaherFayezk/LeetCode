class Solution {
    public int firstMissingPositive(int[] nums) {
        //Solution 1: Sort array and find the first missing positive starting with 1
        //TC : O(nlogn) SC: O(1)
        //Solution 2: HashSet of the values and loop from i=1 to arrayLen +1 
        //if the i is not in the HashSet it is the answer 
        //TC : O(n) SC: O(n)
        //Solution 3: map positive number < array len in the array to an index of the 
        //array 1->0 mark this index by making it negative 
        //TC O(n)   SC O(1)
        int numsLen=nums.length;
        
        for(int i=0;i<numsLen;i++){
            if(nums[i]<0){
                nums[i]=0;
            }
        }
        
        for(int num:nums){
            int index=Math.abs(num)-1;
            if(index>=0 && index<numsLen){
                if(nums[index]==0){//edge case value is 0
                    nums[index]=-1*(numsLen+1);
                }else {
                    nums[index]=-1*Math.abs(nums[index]);
                }
            }
        }
        
        for(int i=0;i<numsLen;i++){
            if(nums[i]>=0){
                return i+1;
            }
        }
        
        return numsLen+1;
    }
}