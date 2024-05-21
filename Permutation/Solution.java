class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList();

        backtrack(nums, permutations, new ArrayList());

        return permutations;
    }

    private void backtrack(int[] nums, List<List<Integer>> permutations, List<Integer> permutation){
        if(permutation.size() == nums.length){
            permutations.add(new ArrayList(permutation));
            return;
        }
        for(int i=0; i<nums.length; i++){
            if(permutation.contains(nums[i])) continue;
            permutation.add(nums[i]);
            backtrack(nums, permutations, permutation);
            permutation.remove(permutation.size()-1);
        }
        
    }
}
//TC O(n*n!)
//SC O(n)