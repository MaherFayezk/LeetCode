class Solution {
    public int[] productExceptSelf(int[] nums) {
        int numsLen = nums.length;
        int[] prefixProd = new int[numsLen];

        prefixProd[0] = 1;
        for (int i = 1; i < numsLen; i++) {
            prefixProd[i] = prefixProd[i - 1] * nums[i - 1];
        }
        int sufixProd = 1;
        for (int i = numsLen - 1; i >= 0; i--) {
            prefixProd[i] = sufixProd * prefixProd[i];
            sufixProd *= nums[i];
        }

        return prefixProd;
    }
    // withput using division
    // TC O(n)
    // SC O(n)
}