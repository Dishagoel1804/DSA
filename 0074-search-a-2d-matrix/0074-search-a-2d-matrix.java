class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n=matrix.length;
        int m=matrix[0].length;
        int p=matrix.length-1;
        for(int i=0;i<n;i++)
        {
            if(matrix[i][m-1]==target)
            return true;
            if(matrix[i][m-1]>target)
            {
                p=i;
                break;
            }
        }
        for(int j=0;j<m;j++)
        {
            if(matrix[p][j]==target)
            return true;
        }
        return false;
    }
}