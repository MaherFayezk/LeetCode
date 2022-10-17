class Solution {
    public int climbStairs(int n) {
        if(n<=3){
            return n;
        }
        int prev1=2;
        int prev2=3;
        int numOfWays=0;
        for(int i=4;i<=n;i++){
            numOfWays=prev1+prev2;
            prev1=prev2;
            prev2=numOfWays;
        }
        
        return numOfWays;
       
    }
}