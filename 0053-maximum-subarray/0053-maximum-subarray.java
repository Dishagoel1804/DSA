class Solution {
    public int maxSubArray(int[] nums) {
        int sum=0;int max=nums[0];
        int i;
        for(i=0;i<nums.length;i++)
        {
            sum+=nums[i];
            if(max<sum)
            max=sum;
            if(sum<0)
            sum=0;
        }
        return max;
    }
}
