import java.lang.Math;
class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit=0;
        int minPrice=Integer.MAX_VALUE;
        
        for(int i=0;i<prices.length;i++){
            minPrice=Math.min(minPrice, prices[i]);
            maxProfit=Math.max(maxProfit, prices[i]-minPrice);
        }
        return maxProfit;
    }
//TC : O(n) 
//SC : O(1)
//The brute formce approache requires for each day 
//to iterate over the remaining days and find the max profit O(n^2)

}