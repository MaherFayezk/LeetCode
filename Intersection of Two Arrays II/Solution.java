class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length){
            intersect(nums2,nums1);
        }
        Map<Integer, Integer> nums1Map= new HashMap();
        List<Integer> intersection= new ArrayList();
        for(int num:nums1){
           nums1Map.putIfAbsent(num,0);
           int occ=nums1Map.get(num)+1;
           nums1Map.put(num,occ);
        }
        for(Integer num: nums2){
            if(nums1Map.containsKey(num) && nums1Map.get(num)>0){
                intersection.add(num);
                int occ= nums1Map.get(num)-1;
                nums1Map.put(num,occ);
            }
        }
      
        int[] res=new int[intersection.size()];
        int i=0;
        for(Integer num: intersection){
            res[i++]=num;
        }
        return res;
    }
}

// TC(O(m+n)) Where m is the length of the larger array and  n is the size of the smaller array 
//SC(O(n)) 
// What if the given array is already sorted? How would you optimize your algorithm?
// We can do binary search, in this case TC (O(nlog(m))) where m is the size of the sorted array
//What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all 
//elements into the memory at once?
// We can load as steam of groups and perfrom binary over each group