class Solution {
    int helper(int dp[][],int i,int j)
    {
        if(i==0 && j==0)
        return 1;
        if(i<0 || j<0)
        return 0;
        if(dp[i][j]!=-1)
        return dp[i][j];
        int up=helper(dp,i-1,j);
        int left=helper(dp,i,j-1);
        return dp[i][j]=up+left;
    }
    public int uniquePaths(int m, int n) {
        int dp[][]=new int[m][n];
        for(int i=0;i<m;i++)
        Arrays.fill(dp[i],-1);
        return helper(dp,m-1,n-1);
    }
}