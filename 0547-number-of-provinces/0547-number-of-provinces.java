class Solution {
    public int findCircleNum(int[][] isConnected) {
        int provinces=0;
        int n=isConnected.length;
        boolean vis[]=new boolean[n];
        for(int i=0;i<n;i++)
        {
            if(!vis[i])
            {
                provinces++;
                dfs(isConnected,i,vis);
            }
        }
        return provinces;
    }
    void dfs(int [][]isConnected,int i,boolean vis[])
    {
        vis[i]=true;
        for(int j=0;j<isConnected.length;j++)
        {
            if(isConnected[i][j]==1 && vis[j]!=true)
            dfs(isConnected,j,vis);
        }
    }
}