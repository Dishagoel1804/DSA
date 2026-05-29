class Solution {
    public int sum(int n,int s)
    {
        while(n!=0)
        {
            s=s+(n%10);
            n=n/10;
        }
        return s;
    }
    public int minElement(int[] nums) {
        int A[]=new int[nums.length];
        for(int i=0;i<nums.length;i++)
        {
            A[i]=sum(nums[i],0);
        }
        int min=nums[0];
        for(int i=0;i<nums.length;i++)
        {
            if(min>A[i])
            min=A[i];
        }
        return min;
    }
}