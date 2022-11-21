class Solution {
    public int maxProfit(int[] prices) {
        int profit=0;
        int maxProfit=0;
        int minPrice=Integer.MAX_VALUE;
        
        for(int i=0;i<prices.length;i++){
            minPrice=Math.min(minPrice,prices[i]);
            profit=Math.max(profit, prices[i]-minPrice);
            if(profit>0){
                maxProfit+=profit;
                minPrice=prices[i];
                profit=0;
            }
        }
        return maxProfit;
    }
//TC O(n)
//SC O(1)
}