class Solution {
    public int minSubArrayLen(int target, int[] nums) {
    
        int minLen=0;
        int leftPointer=0;
        int sum=0;
        
        for(int pointer=0;pointer<nums.length;pointer++){
            sum+=nums[pointer];
            while(sum>=target){
                int currentLen=pointer+1-leftPointer;
                minLen=minLen==0?currentLen:Math.min(minLen,currentLen);
                sum-=nums[leftPointer];
                leftPointer++;
            }
        }
        
        return minLen;
    }
}//TC O(n)