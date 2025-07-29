class Solution {
    int f(int dp[][],String s,String p, int i,int j)
    {
        if(i<0 || j<0)
        return 0;
        if(dp[i][j]!=-1)
        return dp[i][j];
        if(s.charAt(i)==p.charAt(j))
        return dp[i][j]=1+f(dp,s,p,i-1,j-1);
        return dp[i][j]=0+Math.max((f(dp,s,p,i-1,j)),f(dp,s,p,i,j-1)) ;
        //return dp[i][j];
    }
    public int longestPalindromeSubseq(String s) {
        int n=s.length();
        String p="";
        for(int i=0;i<n;i++)
        {
            p=s.charAt(i)+p;
        }
        int dp[][]=new int[n][n];
        for(int i=0;i<n;i++)
        Arrays.fill(dp[i],-1);
        return f(dp,s,p,n-1,n-1);
    }
}