class Solution {
    int count(int matrix[][],int m,int n,int i,int j,int dp[][])
    {
        if(i>=m || i<0 || j>=n|| j<0)
        return 0;
        if(dp[i][j]!=-1)
        return dp[i][j];
        if(matrix[i][j]==0)
        return dp[i][j]=0;
        int r=count(matrix,m,n,i,j+1,dp);
        int d=count(matrix,m,n,i+1,j,dp);
        int di=count(matrix,m,n,i+1,j+1,dp);
        dp[i][j]=1+Math.min(r,Math.min(d,di));
        return dp[i][j];
    }
    public int countSquares(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int dp[][]=new int[m][n];
        for(int i=0;i<m;i++)
        Arrays.fill(dp[i],-1);
        int ans=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(matrix[i][j]==0)
                dp[i][j]=0;
                else if(dp[i][j]==-1)
                dp[i][j]=count(matrix,m,n,i,j,dp);
                ans+=dp[i][j];
            }
        }
        return ans;
    }
}