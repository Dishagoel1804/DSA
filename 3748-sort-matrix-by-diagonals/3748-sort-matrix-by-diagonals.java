class Solution {
    ArrayList<Integer> dfs(int n,int m,int grid[][],int i,int j,int vis[][],ArrayList<Integer> list)
    {
        if(i>=n || i<0 || j<0 || j>=m || vis[i][j]==1)
        return list;
        list.add(grid[i][j]);
        vis[i][j]=1;
        return dfs(n,m,grid,i+1,j+1,vis,list);
    }
    public int[][] sortMatrix(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int A[][]=new int[n][m];
        int vis[][]=new int[n][m];
        for(int i=n-1;i>=0;i--)
        {
            ArrayList<Integer> list=new ArrayList<>();
            list=dfs(n,m,grid,i,0,vis,list);
            Collections.sort(list,Collections.reverseOrder());
            int p=i;int q=0;
            for(int k=0;k<list.size();k++)
            {
                A[p][q]=list.get(k);
                p++;
                q++;
            }
        }
        for(int j=1;j<m;j++)
        {
            ArrayList<Integer> list=new ArrayList<>();
            list=dfs(n,m,grid,0,j,vis,list);
            Collections.sort(list);
            int p=0;int q=j;
            for(int k=0;k<list.size();k++)
            {
                A[p][q]=list.get(k);
                p++;
                q++;
            }
        }
        return A;
    }
}