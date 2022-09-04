class Solution {
    public boolean canJump(int[] nums) {
        //The naive solution is to move step by step untill we reach (0) which means 
        // we cannot reach the next in one step. Then we check if the next is 
        //reachable from any index before the stop point (0). if yes we move on
        //if we reach the las return true  O(n^2)
        
        int steps=nums.length-1;
        int reachable =nums[0];
        
        for(int i=0;i<=steps;i++){
            if(reachable>=i){
                 reachable = Math.max(reachable, i+nums[i]);
            }
           
            if(reachable >=steps){
                return true;
            }
        }
        return false;
    }
    //TC O(n)
    //SC O(1)
}