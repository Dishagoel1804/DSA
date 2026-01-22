class Solution {
    boolean nond(int A[])
    {
        int k=1;
        for(int i=0;i<A.length-1;i++)
        {
            if(A[i]>A[i+1])
            {
                k=0;
                break;
            }
        }
        if(k==0)
        return false;
        return true;
    }
    int[] red(int A[])
    {
        int n=A.length;
        int B[]=new int[n-1];
        int min=Integer.MAX_VALUE;
        int minI=-1;
        int sum=0;
        for(int i=0;i<n-1;i++)
        {
            sum=A[i]+A[i+1];
            if(sum<min)
            {
                min=sum;
                minI=i;
            }
        }
        for(int i=0;i<minI;i++)
        {
            B[i]=A[i];
        }
        B[minI]=min;
        for(int i=minI+1;i<B.length;i++)
        {
            B[i]=A[i+1];
        }
        return B;
    }
    public int minimumPairRemoval(int[] nums) {
        int c=0;
        int C[]=nums.clone();
        while(!nond(C))
        {
            C=red(C);
            c++;
        }
        return c;
    }
}