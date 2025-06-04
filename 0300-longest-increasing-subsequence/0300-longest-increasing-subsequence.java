class Solution {
    int f(int ind,int prev,int nums[],int n,int dp[][])
    {
        if(ind==n)
        return 0;
        if(dp[ind][prev+1]!=-1)
        return dp[ind][prev+1];
        int len=0+f(ind+1,prev,nums,n,dp);
        if(prev==-1||nums[ind]>nums[prev])
        {
            len=Math.max(len,1+f(ind+1,ind,nums,n,dp));
        }
        return dp[ind][prev+1]=len;
    }
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        int dp[][]=new int[n][n+1];
        for(int i=0;i<n;i++)
        Arrays.fill(dp[i],-1);
        return f(0,-1,nums,n,dp);
    }
}