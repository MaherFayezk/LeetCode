class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result= new ArrayList();
        backtrack(result, k, n,0, new LinkedList<Integer>());
        return result;
    }

    public void backtrack(List<List<Integer>> result, int k, int rem, int start, LinkedList<Integer> com){
        if(rem==0 && com.size()==k){
            result.add(new ArrayList(com));
            return;
        }
        else if(rem<0 && com.size()==k){
            return;
        }
        for(int i=start; i<9;i++){
            com.add(i+1);
            backtrack(result, k, rem-(i+1), i+1, com);
            com.removeLast();
        }


    }
}