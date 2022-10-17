class Solution {
    public int rob(int[] nums) {
        int numOfHouses=nums.length;
        if(numOfHouses==1) return nums[0];
        if(numOfHouses==2){
            return Math.max(nums[0],nums[1]);
        }
        return Math.max(helper(nums,0,numOfHouses-2),helper(nums,1,numOfHouses-1));
    }
    
    private int helper (int[]nums, int start, int end){
        int max=0;
        int rob=0;
        int notRob=0;
        
        for(int i=start;i<=end;i++){
           max=Math.max(notRob, nums[i]+rob);
            rob=notRob;
            notRob=max;
        }
        return max;
    }
}

//TC O(n) SC O(1)