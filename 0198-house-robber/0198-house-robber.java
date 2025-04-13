class Solution {
    int helper(int dp[],int ind,int nums[])
    {
        if(ind==0)
        return nums[ind];
        if(ind<0)
        return 0;
        if(dp[ind]!=-1)
        return dp[ind];
        int pick=nums[ind]+helper(dp,ind-2,nums);
        int notpick=0+helper(dp,ind-1,nums);
        return dp[ind]=Math.max(pick,notpick);
    }
    public int rob(int[] nums) {
        int n=nums.length;
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        dp[0]=0;
        return helper(dp,n-1,nums);
    }
}