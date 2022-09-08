class Solution {
    //TC O(nlogn) in worst case O(n^2)
    //SC O(n) for the recursion stack
    public int[] sortArray(int[] nums) {
        if(nums==null|| nums.length==0){
            return nums;
        }
        quickSort(nums,0,nums.length-1);
        
        return nums;
    }
    
    private void quickSort(int[]nums,int start, int end){
        if(start<end) {
            int pivote=partition(nums,start,end);
            quickSort(nums,start,pivote-1);
            quickSort(nums,pivote+1,end);
        }
    }
    
    private int partition(int[]nums,int start, int end){
       int pivote=end;
        int i=start-1;
        for(int j=start;j<end;j++){
            if(nums[j]<=nums[pivote]){
                i++;
                swap(nums,i,j);
            }
        }
        return i;
    }
      private void swap(int[]nums,int p1, int p2){
        int temp=nums[p1];
        nums[p1]=nums[p2];
        nums[p2]=temp;
    }

}