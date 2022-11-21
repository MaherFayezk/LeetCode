class Solution {
    public int[] searchRange(int[] nums, int target) {
        int start=leftMostBS(nums, target);
        
        if(start == nums.length || nums[start]!=target){
            return new int[]{-1,-1};
        }
        int end =leftMostBS(nums, target+1)-1;
        return new int[]{start,end};
    }
    
    private int leftMostBS(int[] nums, int target){
        int left=0;
        int right=nums.length;
        
        while(left<right){
            int mid=(left+right)/2;
            if(nums[mid]<target){
                left=mid+1;
            }else {
                right=mid;
            }
        }
        return left;
    }
}//O(log n)