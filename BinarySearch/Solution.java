class Solution {
    public static void main(String[] args) {
       
    }
   

    public int search(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int middel = start + (end - start) / 2;
            if (target == nums[middel]) {
                return middel;
            } else if (target > nums[middel]) {
                start = middel + 1;
            } else {
                end = middel - 1;
            }
        }
        return -1;
    }
    // TC : O(logn)
}