class Solution {
    public void setZeroes(int[][] matrix) {
       int p[]=new int[matrix.length];
       int q[]=new int[matrix[0].length];
       Arrays.fill(p,-1);
       Arrays.fill(q,-1);
       for(int i=0;i<matrix.length;i++)
       {
        for(int j=0;j<matrix[0].length;j++)
        {
            if(matrix[i][j]==0)
            {
                p[i]=1;
                q[j]=1;
            }
        }
       }
        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                if(p[i]==1 || q[j]==1)
                matrix[i][j]=0;
            }
        }
    }
}