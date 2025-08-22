class Solution {
    public int minimumArea(int[][] grid) {
        int l,b;
        int maxi=Integer.MIN_VALUE;
        int maxj=Integer.MIN_VALUE;
        int mini=Integer.MAX_VALUE;
        int minj=Integer.MAX_VALUE;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[0].length;j++)
            {
                if(grid[i][j]==1)
                {
                    mini = Math.min(mini, i);
                    maxi = Math.max(maxi, i);
                    minj = Math.min(minj, j);
                    maxj = Math.max(maxj, j);
                }
            }
        }
        l=maxi-mini+1;
        b=maxj-minj+1;
        return l*b;
    }
}