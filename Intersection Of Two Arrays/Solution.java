class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length){
            intersection(nums2, nums1);
        }
        Set<Integer> nums1Set= new HashSet();
        for(int num: nums1){
            nums1Set.add(num);
        }
        Set<Integer> intersection= new HashSet();

        for(int num: nums2){
            if(nums1Set.contains(num)){
                intersection.add(num);
            }
        }
        int[] res= intersection.stream()
                            .mapToInt(Integer::intValue)
                            .toArray();
        return res;
    }
}