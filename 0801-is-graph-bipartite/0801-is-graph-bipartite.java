class Solution {
    boolean dfs(int graph[][],int color[],int node,int col)
    {
        color[node]=col;
        for(int j:graph[node])
        {
            if(col==color[j])
            return false;
            if(color[j]==-1 && !dfs(graph,color,j,1-col))
            return false;
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int v=graph.length;
        int color[]=new int[v];
        for(int i=0;i<v;i++)
        {
            color[i]=-1;//-1:uncolored 0:color1 1:color2
        }
        for(int i=0;i<v;i++)
        {
            if(color[i]==-1)
            {
                if(!dfs(graph,color,i,0))
                return false;
            }
        }
        return true;
    }
}