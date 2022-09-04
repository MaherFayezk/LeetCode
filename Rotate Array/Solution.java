class Solution {
    public void rotate(int[] nums, int k) {
        //[1,2,3,4,5] k=2
        k=k%nums.length;
        reverse(nums,0,nums.length-1);  //reverse the whole array [5,4,3,2,1]
        reverse(nums,0,k-1); //reverse the first k nums[4,5,3,2,1]
        reverse(nums,k,nums.length-1); //reverse the second part[4,5,1,2,3]
       
    }
    
    private void reverse(int[]arr,int start, int end){
        while(start<end){
            int temp=arr[start];
            arr[start]=arr[end];
            arr[end]=temp;
            start++;
            end--;
            }
    }
}