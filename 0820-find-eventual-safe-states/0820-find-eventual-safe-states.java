class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n=graph.length;
        List<Integer> safe=new ArrayList<>();
        int vis[]=new int[n];
        for(int i=0;i<n;i++)
        {
            if(dfs(graph,i,vis))
            safe.add(i);
        }
        return safe;
    }
        boolean dfs(int graph[][],int node,int vis[])
        {
            if(vis[node]==1)
            return false;
            if(vis[node]==2)
            return true;
            vis[node]=1;
            for(int it:graph[node])
            {
                if(!dfs(graph,it,vis))
                return false;
            }
            vis[node]=2;
            return true;
        }
}