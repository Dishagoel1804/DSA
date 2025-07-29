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
    public int minInsertions(String s) {
        int N=s.length();
        String p="";
        for(int i=0;i<N;i++)
        p=s.charAt(i)+p;
        int dp[][]=new int[N][N];
        for(int i=0;i<N;i++)
        Arrays.fill(dp[i],-1);
        int a=f(dp,s,p,N-1,N-1);
        return N-a;
    }
}