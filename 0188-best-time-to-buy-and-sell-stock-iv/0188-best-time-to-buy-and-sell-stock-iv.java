class Solution {
    int f(int ind,int buy,int prices[],int n,int dp[][][],int cap)
    {
        if(ind==n || cap==0)
        return 0;
        if(dp[ind][buy][cap]!=-1)
        return dp[ind][buy][cap];
        int profit=0;
        if(buy==1)
        {
            profit=Math.max((-prices[ind]+f(ind+1,0,prices,n,dp,cap)),(0+f(ind+1,1,prices,n,dp,cap)));
        }
        else
        {
             profit=Math.max((prices[ind]+f(ind+1,1,prices,n,dp,cap-1)),(0+f(ind+1,0,prices,n,dp,cap)));
        }
        return dp[ind][buy][cap]=profit;
    }
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        int dp[][][]=new int[n][2][k+1];
        for(int[][] arr2D:dp){
        for(int[] arr1D:arr2D)
        {
            Arrays.fill(arr1D,-1);
        }
        }
        return f(0,1,prices,n,dp,k);
    }
}