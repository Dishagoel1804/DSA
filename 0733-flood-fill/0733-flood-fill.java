class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n=image.length;
        int m=image[0].length;
        if(image[sr][sc]==color)
        return image;

         int drow[]={-1,0,1,0};
        int dcol[]={0,1,0,-1};
        Queue<int[]> q=new LinkedList<>();
        int ocolor=image[sr][sc];
        q.add(new int[]{sr,sc});
        image[sr][sc]=color;
        while(!q.isEmpty())
        {
            int cell[]=q.poll();
            int r=cell[0];
            int c=cell[1];
            for(int i=0;i<4;i++)
            {
                int nrow=r+drow[i];
                int ncol=c+dcol[i];
                if(nrow<n && nrow>=0 && ncol<m &&ncol>=0 && image[nrow][ncol]==ocolor)
                {
                    q.add(new int[]{nrow,ncol});
                    image[nrow][ncol]=color;
                }
            }
        }
        return image;
    }
}