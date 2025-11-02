class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int grid[][]=new int[m][n];
        int dir[][]={{-1,0},{0,1},{1,0},{0,-1}};
        for(int i=0;i<guards.length;i++)
        {
            int a=guards[i][0];
            int b=guards[i][1];
            grid[a][b]=2;
        }
        for(int i=0;i<walls.length;i++)
        {
            int a=walls[i][0];
            int b=walls[i][1];
            grid[a][b]=1;
        }
        for(int[] g:guards)
        {
            int r=g[0];
            int c=g[1];
            for(int[] d:dir)
            {
                int nr=r+d[0];
                int nc=c+d[1];
                while(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc]!=1 && grid[nr][nc]!=2)
                {
                    if(grid[nr][nc]==0)
                    grid[nr][nc]=3;
                    nr+=d[0];
                    nc+=d[1];
                }
            }
        }
        int c=0;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(grid[i][j]==0)
                c++;
            }
        }
        return c;
    }
}