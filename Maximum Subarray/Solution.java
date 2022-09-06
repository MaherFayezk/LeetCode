class Solution {
    public int maxSubArray(int[] nums) {
        //The brute force solution is iterating over each element and calculate 
        //the max as long as it is increasing using another loop TC O(n^2)
        
        //The better solution is Kaden's Algorithm 
        //TC O(n) SC O(1)
        int currentMax=nums[0];
        int max=nums[0];
        
        for(int i=1;i<nums.length;i++){
            currentMax=Math.max(currentMax+nums[i], nums[i]);
            max=Math.max(max,currentMax);
        }
        
        return max;
    }
}