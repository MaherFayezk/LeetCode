class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //the brute force solution is to iterate over the array 
        //and for each sliding window we find the max in the window 
        //TC O(k*(n-k))
        
        //Using double ended queue Deque 
        //TC O(n)   SC O(n)
        int[] res=new int[nums.length-k+1];
        Deque<Integer> max=new LinkedList();
        
        for(int i=0,j=0;i<nums.length;i++){
            
            while(max.size()>0&& nums[max.getLast()]<nums[i]){
                max.removeLast();
            }
            max.addLast(i);
            if(max.getFirst()<i-k+1){
                max.removeFirst();
            }
            
            if(i-k+1>=0){
                res[j]=nums[max.getFirst()];
                j++;
            }
            
        }
         return res;
    }
   
}