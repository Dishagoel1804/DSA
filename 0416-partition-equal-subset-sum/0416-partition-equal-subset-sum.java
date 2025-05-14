class Solution {
    Boolean dp[][];
    boolean solve(int idx,int target,int nums[])
    {
        if(target==0)
        return true;
        if(idx==nums.length|| target<0)
        return false;
        if(dp[idx][target]!=null)
        return dp[idx][target];
        boolean pick=false;
        if(target>=nums[idx])
        {
            pick= solve(idx+1,target-nums[idx],nums);
        }
        boolean notpick= solve(idx+1,target,nums);
        return dp[idx][target]=pick||notpick;
    }
    public boolean canPartition(int[] nums) {
        int s=0;
        for(int i=0;i<nums.length;i++)
        s+=nums[i];

        if(s%2!=0)
        return false;
                int target=s/2;
                dp=new Boolean[nums.length][target+1];
        return solve(0,target,nums);
    }
}