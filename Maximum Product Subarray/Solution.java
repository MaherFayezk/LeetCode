class Solution {
    public int maxProduct(int[] nums) {
        int maxProd = nums[0];
        int min = 1, max = 1;

        for(int i = 0; i < nums.length; i++){
            int temp = min;
            min = Math.min(nums[i], Math.min( nums[i]*min, nums[i]*max));
            max = Math.max(nums[i], Math.max(nums[i]*temp, nums[i]*max));

            maxProd = Math.max(maxProd, max);
        }
        return maxProd;
    }
}