class Solution {

    int dr[]={-1,1,0,0};
    int dc[]={0,0,1,-1};
    boolean dfs(List<List<Integer>> grid,int h,int best[][],int r,int c)
    {
        int m=grid.size();
        int n=grid.get(0).size();

        if(r<0 || c<0 || r>=m || c>=n)
        return false;

        if(grid.get(r).get(c)==1)
        h--;

        if(h==0)
        return false;

        if(r==m-1 && c==n-1)
        return true;

        if(best[r][c]>=h)
        return false;

        best[r][c]=h;

        for(int i=0;i<4;i++)
        {
            if(dfs(grid,h,best,r+dr[i],c+dc[i]))
            return true;
        }
        return false;
    }
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m=grid.size();
        int n=grid.get(0).size();
        int best[][]=new int[m][n];
        for(int i=0;i<m;i++)
        Arrays.fill(best[i],-1);
        return dfs(grid,health,best,0,0);
    }
}