class Solution {
//O(log n+m)
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length){
            return findMedianSortedArrays(nums2, nums1);
        }
        int x = nums1.length;
        int y = nums2.length;
        int low = 0;
        int high = x;
        while ( low <= high ){
            int partitionX = (low + high)/2;
            int partitionY = (x + y + 1)/2 - partitionX;

            int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
            int minRightX = (partitionX == x) ? Integer.MAX_VALUE : nums1[partitionX];

           int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
           int minRightY = (partitionY == y) ? Integer.MAX_VALUE : nums2[partitionY];

            if(maxLeftX <= minRightY && maxLeftY <= minRightX){
                if((x + y) % 2 == 0){
                    return (double) (Math.min(minRightX, minRightY) + Math.max(maxLeftX, maxLeftY)) / 2;
                }else {
                    return Math.max(maxLeftX, maxLeftY);
                } 
            }else if (maxLeftX > minRightY){
                high = partitionX - 1;
            }else {
                low = partitionX + 1;
            }
        }
        return -1;
    }
/*
//Brute force TC O(n+m)
//SC O(n+m)
     public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        int[] mergedArray= new int[m+n];
        int i=0, j=0,k=0;

        while(i<m && j<n){
            if(nums1[i]<nums2[j]){
                mergedArray[k]=nums1[i];
                i++;
            }else {
                mergedArray[k]=nums2[j];
                j++;
            }
            k++;
        }
        while(i<m){
             mergedArray[k]=nums1[i];
             i++;
             k++;
        }
         while(j<n){
             mergedArray[k]=nums2[j];
             j++;
             k++;
        }
        int len=n+m;
        if(len%2==1){
            return mergedArray[len/2];
        }
        double median= (double)(mergedArray[(len/2)-1]+mergedArray[len/2])/2;
        return median;
    }
    */
}

