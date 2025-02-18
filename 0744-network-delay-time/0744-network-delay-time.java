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
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int time[]:times)
        {
            adj.get(time[0]).add(new Pair(time[1],time[2]));
        }
        int dist[]=new int[n+1];
        for(int i=1;i<=n;i++)
        {
            dist[i]=Integer.MAX_VALUE;
        }
        dist[k]=0;
        PriorityQueue<Pair> q=new PriorityQueue<>((x, y) -> x.first - y.first);
        q.add(new Pair(0,k));
        while(!q.isEmpty())
        {
            Pair it=q.poll();
            int time=it.first;
            int node=it.second;
            if(time>dist[node])
            continue;
            for(Pair iter:adj.get(node))
            {
                int t=iter.second;
                int d=iter.first;
                if(time+t<dist[d])
                {
                    dist[d]=time+t;
                    q.add(new Pair(dist[d],d));
                }
            }
        }
            int max=0;
            for(int i=1;i<=n;i++)
            {
                if(dist[i]==Integer.MAX_VALUE)
                return -1;
                max=Math.max(max,dist[i]);
            }
            return max;
    }
}