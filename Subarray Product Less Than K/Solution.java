class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k<=1)return 0;
        int subArrays=0;
        int prod=1;
        int left=0;
        for(int right=0;right<nums.length; right++){
            prod*=nums[right];
            while(prod>=k && left<nums.length){
                prod/=nums[left++];
            }
            subArrays+=right-left+1;
        }
        return subArrays;
        //TC O(n)
	//SC O(1)  Sliding window 
    }
//Brute Force approach O(n^2)
public int numSubarrayProductLessThanK2(int[] nums, int k) {
        int subArrays=0;
        
        for(int i=0;i<nums.length;i++){
            int prod=nums[i];
            if(prod<k){
                subArrays++;
            }
            for(int j=i+1;j<nums.length && prod<k;j++){
                prod*=nums[j];
                if(prod<k){
                    subArrays++;
                }
            }
        }
        
        return subArrays;
        
    }
}