class Solution {
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
 public void sortColors2(int[] nums) {
       int left=0, mid=0,right=nums.length-1;
        
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
    
}