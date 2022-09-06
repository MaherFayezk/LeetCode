class Solution {
    
 public int trap(int[] height) {
//Using dynamic programming 2 pointers
//TC O(n)
//SC O(1)
        int water=0;
        int left=0;
        int right=height.length-1;
         int current;
        while(left<right){
            if(height[left]<=height[right]){
                current =left;
                while(height[++left]<height[current]){
                    water+=height[current]-height[left];
                }
            }
            else {
                current=right;
                while(height[--right]<height[current]){
                    water+=height[current]-height[right];
                }
            }
        }
        return water;
    }



public int trap2(int[] height) {
        //brute force solution is, for each element, find the left max and right max 
        //and compute the water untill the min between the left and right
        
        
        int water=0;
        int len=height.length;
        for(int i=1;i<len-1;i++){
            
            int leftMax = height[i];
            for (int j = 0; j < i; j++) {
                leftMax = Math.max(leftMax, height[j]);
            }
            int rightMax = height[i];
            for (int j = i + 1; j < len; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }
            water+=Math.min(leftMax,rightMax)-height[i];
        }
        return water;
    }
    
}