class Solution {
    int f(int dp[][],String text1,String text2,int i,int j)
    {
        if(i<0 || j<0)
        return 0;
        if(dp[i][j]!=-1)
        return dp[i][j];
        if(text1.charAt(i)==text2.charAt(j))
        return dp[i][j]=1+f(dp,text1,text2,i-1,j-1);
        return dp[i][j]=0+Math.max(f(dp,text1,text2,i-1,j),f(dp,text1,text2,i,j-1));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int N=text1.length();
        int M=text2.length();
        int dp[][]=new int[N][M];
        for(int i=0;i<N;i++)
        {
            Arrays.fill(dp[i],-1);
        }
        return f(dp,text1,text2,N-1,M-1);
    }
}