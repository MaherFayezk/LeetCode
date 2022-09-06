class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // TC O(n^2)
        // SC O(1)
        List<List<Integer>> ans = new ArrayList();
        if (nums == null || nums.length < 3) {
            return ans;
        }
        Arrays.sort(nums);

        int left;
        int right;

        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                left = i + 1;
                right = nums.length - 1;
                int remaining = 0 - nums[i];
                while (left < right) {
                    if (nums[left] + nums[right] == remaining) {
                        ans.add(new ArrayList(Arrays.asList(nums[left], nums[right], nums[i])));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    } else if (remaining > nums[left] + nums[right]) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }

        return ans;
    }
}