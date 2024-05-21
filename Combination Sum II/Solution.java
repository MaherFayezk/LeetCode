class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> combinations= new ArrayList();
        dfs(candidates, combinations, new ArrayList(), target, 0,0);
        return combinations;
    }

    private void dfs(int[] nums, List<List<Integer>> combinations, List<Integer> comb, int target, int currentSum, int start){
        if(currentSum==target){
            combinations.add(new ArrayList<>(comb));
        }else if(currentSum>target){
            return;
        }

        for(int i=start; i<nums.length; i++){
            if(i>start && nums[i]==nums[i-1]){
                continue;
            }
            comb.add(nums[i]);
            dfs(nums, combinations, comb, target, currentSum + nums[i],i+1);
            comb.remove(comb.size()-1);
        }
    }
}