class Solution {
    int f(int ind,int dp[][],int amount,int coins[])
    {
        if(ind==0)
        {
            if(amount%coins[0]==0)
            return amount/coins[0];
            return (int)1e9;
        }
        if(dp[ind][amount]!=-1)
        return dp[ind][amount];
        int notake=0+f(ind-1,dp,amount,coins);
        int take=(int)1e9;
        if(coins[ind]<=amount)
        {
            take=1+f(ind,dp,amount-coins[ind],coins);
        }
        return dp[ind][amount]=Math.min(take,notake);
    }
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
       int dp[][]=new int[n][amount+1];
       for(int i=0;i<n;i++)
       Arrays.fill(dp[i],-1);
       int ans=f(n-1,dp,amount,coins);
       if(ans>=1e9)
       return -1;
       return ans;
    }
}