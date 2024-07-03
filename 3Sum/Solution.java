/*
/////////////////// review ////////////////////////
https://leetcode.com/problems/3sum/description/
Given an integer array nums, return all the triplets 
[nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

Notice that the solution set must not contain duplicate triplets.

Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation: 
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.
Example 2:

Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.
Example 3:

Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.
 

*/
class Solution {
public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList();
        for(int i=0; i<nums.length-2; i++){
            if(i==0 || nums[i] != nums[i-1]){//skip duplicates by skiping previously processed elements 
                int left = i + 1;
                int right = nums.length - 1;
                while(left < right){
                    int sum = nums[i] + nums[left] + nums[right];
                    if(sum == 0){
                        result.add(List.of(nums[i], nums[left], nums[right]));
                        while(left < nums.length-1 && nums[left]==nums[left+1]) left++;//skip duplicates from left
                        while(right > 0 && nums[right]==nums[right-1]) right--;//skip duplicates from right
                        left++;
                        right--;
                    }
                    else if(sum > 0)
                        right--;
                    else 
                        left++;
                }
            }
        }
        return result;
    }
//solution 2 using HashSet to avoid duplicates 
    public List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet();
        for(int i=0; i<nums.length; i++){
            int left = i + 1;
            int right = nums.length - 1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0){
                    result.add(List.of(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                }
                else if(sum > 0)
                    right--;
                else 
                    left++;
            }
        }
        return new ArrayList(result);
    }
}