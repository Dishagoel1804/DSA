class Solution {
    int f(int dp[][],String s,String p,int i,int j)
    {
        if(i<0 || j<0)
        return 0;
        if(dp[i][j]!=-1)
        return dp[i][j];
        if(s.charAt(i)==p.charAt(j))
        return dp[i][j]=1+f(dp,s,p,i-1,j-1);
        return dp[i][j]=0+Math.max((f(dp,s,p,i-1,j)),(f(dp,s,p,i,j-1)));
    }
    public int minDistance(String word1, String word2) {
        int N=word1.length();
        int M=word2.length();
        int dp[][]=new int[N][M];
        for(int i=0;i<N;i++)
        Arrays.fill(dp[i],-1);
        int a=f(dp,word1,word2,N-1,M-1);
        return ((N+M)-(2*a));
    }
}