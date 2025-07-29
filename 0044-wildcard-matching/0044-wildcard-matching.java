class Solution {
    int f(int dp[][],String s,String p,int i,int j)
    {
        if(i<0 && j<0)
        return 1;
        if(i>=0 && j<0)
        return 0;
        if(i<0 && j>=0)
        {
            for(int ii=0;ii<=j;ii++)
            {
                if(p.charAt(ii)!='*')
                return 0;
            }
            return 1;
        }
        if(dp[i][j]!=-1)
        return dp[i][j];
        if(s.charAt(i)==p.charAt(j) || p.charAt(j)=='?')
        return dp[i][j]=f(dp,s,p,i-1,j-1);
        if(p.charAt(j)=='*')
        return dp[i][j]=(f(dp,s,p,i-1,j)==1||f(dp,s,p,i,j-1)==1)?1:0;
        return dp[i][j]=0;
    }
    public boolean isMatch(String s, String p) {
        int N=s.length();
        int M=p.length();
        int dp[][]=new int[N][M];
        for(int i=0;i<N;i++)
        {
            Arrays.fill(dp[i],-1);
        }
        return f(dp,s,p,N-1,M-1)==1;
    }
}