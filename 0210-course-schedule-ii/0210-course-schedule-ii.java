class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int v=numCourses;
        int in[]=new int[v];
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<v;i++)
        adj.add(new ArrayList<>());

        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int pre = prerequisite[1]; 
            adj.get(pre).add(course);
            in[course]++;  // Increase in-degree
        }

        int topo[]=new int[v]; 
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<v;i++)
        {
            if(in[i]==0)
            q.add(i);
        }
        int c=0;int i=-1;
        while(!q.isEmpty())
        {
            int node=q.peek();
            q.remove();
            c++;
            topo[++i]=node;
            for(int it:adj.get(node))
            {
                in[it]--;
                if(in[it]==0)
                q.add(it);
            }
        }
        if(c==v)
        return topo;
        return new int[0];
    }
}