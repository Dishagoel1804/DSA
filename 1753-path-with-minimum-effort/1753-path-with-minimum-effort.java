class Pair
{
    int first,second,third;
    Pair(int first,int second,int third)
    {
        this.first=first;
        this.second=second;
        this.third=third;
    }
}
class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n=heights.length;
        int m=heights[0].length;
        int dist[][]=new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            dist[i][j]=Integer.MAX_VALUE;
        }
        PriorityQueue<Pair> q=new PriorityQueue<>((x, y) -> x.third - y.third);
        q.add(new Pair(0,0,0));
        dist[0][0]=0;
        int drow[]={-1,0,1,0};
        int dcol[]={0,1,0,-1};
         while(!q.isEmpty())
        {
            Pair p=q.poll();
            int r=p.first;
            int c=p.second;
            int s=p.third;
             if (r == n - 1 && c == m - 1) {
                return s;
            }
            for(int i=0;i<4;i++)
            {
                int nrow=r+drow[i];
                int ncol=c+dcol[i];
                if(nrow<n && nrow>=0 && ncol<m && ncol>=0)
                {
                    int newEffort=Math.max(s,(Math.abs(heights[r][c]-heights[nrow][ncol])));
                if(newEffort<dist[nrow][ncol])
                {
                    dist[nrow][ncol]=newEffort;
                    q.add(new Pair(nrow,ncol,newEffort));
                }
                }
            }
        }
        return -1;
    }
}