class Pair
{
    int first,second;
    Pair(int first,int second)
    {
        this.first=first;
        this.second=second;
    }
}
class Solution {
    public int numEnclaves(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int vis[][]=new int[n][m];
        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==0)
                vis[i][j]=1;
                else
                vis[i][j]=0;
                if((grid[i][j]==1)&&(i==0||j==0||i==(n-1)||j==(m-1)))
                {
                    q.add(new Pair(i,j));
                    vis[i][j]=1;
                }
            }
        }
        int drow[]={-1,0,1,0};
        int dcol[]={0,1,0,-1};
        while(!q.isEmpty())
        {
            Pair p=q.poll();
            int i=p.first;
            int j=p.second;
             for (int k = 0; k < 4; k++) {
                int nrow = i + drow[k];
                int ncol = j + dcol[k];
           if(nrow<n && nrow>=0 && ncol<m && ncol>=0 && vis[nrow][ncol]==0 && grid[nrow][ncol]==1){
           q.add(new Pair(nrow, ncol));
           vis[nrow][ncol]=1;
           }
           }
        }
        int c=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(vis[i][j]==0 && grid[i][j]==1)
                c++;
            }
        }
        return c;
    }
}