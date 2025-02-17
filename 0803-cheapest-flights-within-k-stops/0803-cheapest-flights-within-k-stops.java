class Pair
{
    int first,second;
    Pair(int first,int second)
    {
        this.first=first;
        this.second=second;
    }
}
class Tuple
{
    int first,second,third;
    Tuple(int first,int second,int third)
    {
        this.first=first;
        this.second=second;
        this.third=third;
    }
}
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        int m=flights.length;
        for(int i=0;i<m;i++)
        {
            adj.get(flights[i][0]).add(new Pair(flights[i][1],flights[i][2]));
        }    
        int dist[]=new int[n];
        for(int i=0;i<n;i++)
        {
            dist[i]=Integer.MAX_VALUE;
        }
        dist[src]=0;
        Queue<Tuple> q=new LinkedList<>();
        q.add(new Tuple(0,src,0));
        while(!q.isEmpty())
        {
            Tuple it=q.poll();
            int stops=it.first;
            int node=it.second;
            int cost=it.third;
            if(stops>k)
            continue;
            for(Pair iter:adj.get(node))
            {
               int dcost=iter.second;
               int d=iter.first;
               if(cost+dcost<dist[d] && stops<=k)
               {
                dist[d]=cost+dcost;
                q.add(new Tuple(stops+1,d,cost+dcost));
               } 
            }
        }
        if(dist[dst]==Integer.MAX_VALUE)
        return -1;
        return dist[dst];
    }
}