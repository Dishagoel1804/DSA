class Solution {
    public int[] twoSum(int[] nums, int target) {
        int i,a,j,p=0,q=0;
        int b[]=new int[2];
        outer:
        for(i=0;i<nums.length;i++)
        {
            a=target-nums[i];
            for(j=0;j<nums.length;j++)
            {
                if(i!=j)
                {
                if(a==nums[j])
                {
                    p=j;
                    q=i;
                    break outer;
                }
                }
            }
        }
        b[0]=q;
        b[1]=p;
        return b;
    }
}