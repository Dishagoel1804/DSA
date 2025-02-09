class Pair
{
    int first,second,third;
    Pair(int first,int second,int third)
    {
        this.first=first;
        this.second=second;
        this.third=third;
    }
}
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }
        int vis[][]=new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            vis[i][j]=-1;
        }
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(0,0,1));
        vis[0][0]=1;
        int st=0;
        int drow[]={-1,-1,0,1,1,1,0,-1};
        int dcol[]={0,1,1,1,0,-1,-1,-1};
        while(!q.isEmpty())
        {
            Pair p=q.poll();
            int r=p.first;
            int c=p.second;
            int s=p.third;
             if (r == n - 1 && c == n - 1) {
                return s;
            }
            //st=Math.max(s,st);
            for(int i=0;i<8;i++)
            {
                int nrow=r+drow[i];
                int ncol=c+dcol[i];
                if(nrow<n && nrow>=0 && ncol<n && ncol>=0 && vis[nrow][ncol]==-1 && grid[nrow][ncol]==0)
                {
                q.add(new Pair(nrow,ncol,s+1));
                vis[nrow][ncol]=1;
                }
            }
        }
        return -1;
    }
}