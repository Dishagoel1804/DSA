class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int max=Integer.MIN_VALUE;int s=0;
        for(int i=0;i<n/2;i++)
        {
            s=nums[i]+nums[n-i-1];
            max=Math.max(max,s);
        }
        return max;
    }
}