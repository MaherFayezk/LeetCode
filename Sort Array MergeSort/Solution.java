import java.util.Arrays;

class Solution {
    public int[] sortArray(int[] nums) {
        if(nums==null|| nums.length==0){
            return nums;
        }
        mergeSort(nums,0,nums.length-1);
        return nums;
    }
    
    private void mergeSort(int[]nums,int left, int right){
        if(left>=right) return;
        int mid=left+(right-left)/2;
        mergeSort(nums,left,mid);
        mergeSort(nums,mid+1,right);
        merge(nums,left,right);
    }
    
    private void merge(int[]nums,int left, int right){
        int mid=left +(right-left)/2;
        int[] temp=new int[right-left+1];
        int i=left;
        int j=mid+1;
        int k=0;
        
        while(i<=mid || j<=right){
            if(i>mid||j<=right && nums[i]>nums[j]){
                temp[k]=nums[j];
                j++;
            }
            else {
                temp[k]=nums[i];
                i++;
            }
            k++;
        }
        System.arraycopy(temp,0,nums,left,right-left+1);
    }

    
    public int[] sortArray1(int[] nums) {
        //TC O(nlogn)
        //SC O(n)
        if (nums.length == 1) {
            return nums;
        }
        int numsLength = nums.length;
        int middle = nums.length / 2;
        int[] left = Arrays.copyOfRange(nums, 0, middle);
        int[] right = Arrays.copyOfRange(nums, middle, numsLength);
        return merge1(sortArray(left), sortArray(right));

    }

    private int[] merge1(int[] left, int[] right) {
        int[] sorted = new int[left.length + right.length];
        int rightIndex = 0, leftIndex = 0;
        while (rightIndex < right.length || leftIndex < left.length) {
            if (rightIndex < right.length && leftIndex < left.length) {
                if (right[rightIndex] < left[leftIndex]) {
                    sorted[rightIndex + leftIndex] = right[rightIndex];
                    rightIndex++;
                } else {
                    sorted[rightIndex + leftIndex] = left[leftIndex];
                    leftIndex++;
                }
            } else {
                if (rightIndex < right.length) {
                    sorted[rightIndex + leftIndex] = right[rightIndex];
                    rightIndex++;
                } else if (leftIndex < left.length) {
                    sorted[rightIndex + leftIndex] = left[leftIndex];
                    leftIndex++;
                }
            }

        }

        return sorted;

    }
}