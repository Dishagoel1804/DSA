class Solution {
    public int maxProfit(int[] prices) {
        int min=prices[0];
        int maxpro=0;
        int n=prices.length;
        for(int i=0;i<n;i++)
        {
            int cost=prices[i]-min;
            maxpro=Math.max(maxpro,cost);
            min=Math.min(min,prices[i]);
        }
        return maxpro;
    }
}