/*
https://leetcode.com/problems/sort-colors/
Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.
Example 1:

Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Example 2:

Input: nums = [2,0,1]
Output: [0,1,2]
 
Constraints:
n == nums.length
1 <= n <= 300
nums[i] is either 0, 1, or 2.
 

Follow up: Could you come up with a one-pass algorithm using only constant extra space?
*/


class Solution {
 public void sortColors2(int[] nums) {
       int left=0;
       int mid=0; //mid starts at 0
       int right=nums.length-1;
        
        while(mid<=right){
            if(nums[mid]==0){
                swap(nums,mid,left);
                left++;
                mid++;
            }
            else if(nums[mid]==1){
                mid++;
            }
            else {
                swap(nums,mid,right);
                right--;
            }
           
        }
        
    }
    private void swap(int[]nums, int index1,int index2){
        int temp=nums[index1];
        nums[index1]=nums[index2];
        nums[index2]=temp;
    }

    public void sortColors(int[] nums) {
        int redCount=0,whiteCount=0,blueCount=0;
        for(int color: nums){
            if(color==0){
                redCount++;
            }
            else if(color==1){
                whiteCount++;
            }
            else {
                blueCount++;
            }
        }
        
        fillArray(nums,0,redCount-1,0);
        fillArray(nums,redCount,redCount+whiteCount-1,1);
        fillArray(nums,redCount+whiteCount, nums.length-1,2);
        
    }
    
    private void fillArray(int[] arr, int startInd, int endInd, int val){
        while (startInd<=endInd){
            arr[startInd]=val;
            startInd++;
        }
    }
    
}