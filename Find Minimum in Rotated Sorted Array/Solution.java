class Solution {
    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int min= Integer.MAX_VALUE;
        int leftIndex=0;
        int rightIndex=nums.length-1;
         if (nums[rightIndex] > nums[0]) {
            return nums[0];
        }
        while(leftIndex<=rightIndex){
            int mid=leftIndex+(rightIndex-leftIndex)/2;
            if(min>nums[mid]){
                min=nums[mid];
            }
            if(nums[mid]>=nums[leftIndex]){// first hald is the sorted one
                if(min>nums[leftIndex]){
                     min=nums[leftIndex];
                }
                leftIndex=mid+1;
            }
            else {
                rightIndex=mid-1;
            }
        }
        return min;
    }
}