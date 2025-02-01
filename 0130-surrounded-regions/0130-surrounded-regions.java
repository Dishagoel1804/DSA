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
    public void solve(char[][] board) {
        int n=board.length;
        int m=board[0].length;
        Queue<Pair> q=new LinkedList<>();
        int vis[][]=new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(board[i][j]=='X')
                vis[i][j]=1;
                else
                vis[i][j]=0;
                if(i==0||i==(n-1)||j==0||(j==m-1))
                {
                    if(board[i][j]=='O')
                    {
                    q.add(new Pair(i,j));
                    vis[i][j]=1;
                    }
                }
            }
        }
        int drow[]={-1,0,1,0};
        int dcol[]={0,1,0,-1};
        while(!q.isEmpty())
        {
            Pair p=q.poll();
           int i=p.first;
           int j=p.second;
           //q.remove();
           //vis[i][j]=1;
            for (int k = 0; k < 4; k++) {
                int nrow = i + drow[k];
                int ncol = j + dcol[k];
           if(nrow<n && nrow>=0 && ncol<m && ncol>=0 && vis[nrow][ncol]==0 && board[nrow][ncol]=='O'){
           q.add(new Pair(nrow, ncol));
           vis[nrow][ncol]=1;
           }
        }
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(vis[i][j]==0 && board[i][j]=='O')
                board[i][j]='X';
            }
        }
    }
}