class Solution {
    public int[][] divideArray(int[] nums, int k) {
        int n=nums.length;
        Arrays.sort(nums);
        int A[][]=new int[n/3][3];
        int a=0;
        for(int i=0;i<n/3;i++)
        {
            for(int j=0;j<3;j++)
            {
                A[i][j]=nums[a];
                a++;
            }
            if((A[i][2]-A[i][0])>k)
            return (new int[0][0]);
        }
        return A;
    }
}