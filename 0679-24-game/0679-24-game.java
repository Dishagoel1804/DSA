class Solution {
    public boolean judgePoint24(int[] cards) {
        double nums[]=new double[cards.length];
        for(int i=0;i<cards.length;i++)
        {
            nums[i]=cards[i];
        }
        return solve(nums);
    }
    boolean solve(double[] nums)
    {
        int n=nums.length;
        if(n==1)
        return Math.abs(nums[0]-24)<1e-6;
        for(int i=0;i<n;i++)
        {
            for(int j=i+1;j<n;j++)
            {
                double ans[]=new double[n-1];
                int ind=0;
                for(int k=0;k<n;k++)
                {
                    if(k!=i && k!=j)
                    ans[ind++]=nums[k];
                }
                for(double val:compute(nums[i],nums[j]))
                {
                    ans[ind]=val;
                    if(solve(ans))
                    return true;
                }
            }
        }
        return false;
    }
    double[] compute(double a,double b)
    {
        return new double[]{
            a+b,
            a-b,
            b-a,
            a*b,
            (a!=0)?b/a:Double.NaN,
            (b!=0)?a/b:Double.NaN
        };
    }
}