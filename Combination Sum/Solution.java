class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result=new ArrayList();
        backtrack(candidates, result, target, 0, new LinkedList(), 0);
        return result;
    }

    public void backtrack(int[] candidates, List<List<Integer>> result, int target, int sum, LinkedList<Integer> com, int start){
        if(sum==target){
            result.add(new ArrayList(com));
            return;
        }else if (sum>target){
            return;
        }
        for(int i=start; i<candidates.length; i++){
                com.add(candidates[i]);
                 backtrack(candidates, result, target, sum+candidates[i], com, i);
                 com.removeLast();
        }
    }
}