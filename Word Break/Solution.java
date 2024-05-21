class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet(wordDict);
        boolean [] dp = new boolean[s.length() + 1];
        dp[0]=true;
        for(int i=0; i<s.length(); i++){//O(n)
            int j=0;
            while(j<=i){//O(n)
		String substring = s.substring(j,i+1);//O(n)
                if(wordSet.contains(substring) && dp[j]){
                    dp[i+1]=true;
                }
                j++;
            }

        }
        return dp[dp.length-1];
    }
}

//TC O(n^3)
//SC O(n)
