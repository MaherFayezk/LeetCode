class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> answer=new ArrayList<>();
        dfs(nums, answer, new ArrayList<>(), 0);
        return answer;
    }
    
    private void dfs(int[] nums, List<List<Integer>> list, List<Integer> sub, int start){
        list.add(new ArrayList(sub));
        for(int i=start; i<nums.length; i++){
             if(i>start && nums[i]==nums[i-1]){
                continue;
            }
            sub.add(nums[i]);
            dfs(nums, list, sub, i+1);
            sub.remove(sub.size()-1);
            
        }
    }
}

//TC O(n* 2^2)
//SC O(n)