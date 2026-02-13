class Solution {
    public int maxProfit(int[] prices) {
        int profit=0;
        int max=0;
        int cost=prices[0];
        for(int i=0;i<prices.length;i++)
        {
            profit=prices[i]-cost;
            if(profit>max)
            {
                max=profit;
            }
            else
            cost=Math.min(prices[i],cost);
        }
        return max;
    }
}