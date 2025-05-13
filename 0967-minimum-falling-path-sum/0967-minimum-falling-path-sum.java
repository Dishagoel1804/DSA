class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int s=0;
        for(int i=n-2;i>=0;i--)
        {
            for(int j=0;j<n;j++)
            {
                int down=matrix[i+1][j];
                int left=(j>0)?matrix[i+1][j-1]:Integer.MAX_VALUE;
                int right=(j<n-1)?matrix[i+1][j+1]:Integer.MAX_VALUE;
                matrix[i][j]+=Math.min(Math.min(down,left),right);
            }
        }
        int min=Integer.MAX_VALUE;
        for(int j=0;j<n;j++)
        min=Math.min(min,matrix[0][j]);
        return min;
    }
}