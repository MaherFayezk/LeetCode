class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        int[] mergedArray=new int[m+n];
        
        int nums1Len=nums1.length-1;
        
        while(m>0 || n>0){
            int val1=m>0?nums1[m-1]:Integer.MIN_VALUE;
             int val2=n>0?nums2[n-1]:Integer.MIN_VALUE;
            if(val1>val2){
                nums1[nums1Len]=val1;
                m--;
            }
            else {
                nums1[nums1Len]=val2;
                n--;
            }
            nums1Len--;
        }
        
    }
//TC O(n+m)
//SC O(1)
}