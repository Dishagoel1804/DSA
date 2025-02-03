class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
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

        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<v;i++)
        {
            if(in[i]==0)
            q.add(i);
        }
        int c=0;
        while(!q.isEmpty())
        {
            int node=q.peek();
            q.remove();
            c++;
            for(int it:adj.get(node))
            {
                in[it]--;
                if(in[it]==0)
                q.add(it);
            }
        }
        return (c==v);
    }
}