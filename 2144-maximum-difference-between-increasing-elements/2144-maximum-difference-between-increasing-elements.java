class Solution {
    public int maximumDifference(int[] nums) {
        int min=nums[0];
        int n=nums.length;
        int maxdiff=-1;
        for(int i=1;i<n;i++)
        {
            if(nums[i]>min)
            maxdiff=Math.max(maxdiff,nums[i]-min);
            else
            min=nums[i];
        }
        return maxdiff;
    }
}