class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++)
        {
            int A[]=new int[10];
            for(int j=0;j<9;j++)
            {
                if(board[i][j]!='.')
                {
                int a=board[i][j]-'0';
                ++A[a];
                if(A[a]>1)
                return false;
                }
            }
        }
        for(int i=0;i<9;i++)
        {
            int A[]=new int[10];
            for(int j=0;j<9;j++)
            {
                if(board[j][i]!='.')
                {
                int a=board[j][i]-'0';
                ++A[a];
                if(A[a]>1)
                return false;
                }
            }
        }
        for(int i=0;i<9;i++)
        {
            int A[]=new int[10];
            for(int j=0;j<3;j++)
            {
                for(int k=0;k<3;k++)
                {
                    int col=3*(i%3)+j;
                    int row=3*(i/3)+k;
                    if(board[row][col]!='.')
                {
                int a=board[row][col]-'0';
                ++A[a];
                if(A[a]>1)
                return false;
                }
                }
            }

        }
        return true;
    }
}