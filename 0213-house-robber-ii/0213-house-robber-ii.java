class Solution {
    int helper(int nums[])
    {
        int n=nums.length;
        int prev=nums[0];
        int prev2=0;int nottake=0;
        for(int i=1;i<n;i++)
        {
            int take=nums[i];
            if(i>1)
            take+=prev2;
            nottake=0+prev;
            int curi=Math.max(take,nottake);
            prev2=prev;
            prev=curi;
        }
        return prev;
    }
    
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1)
        return nums[0];
        
        int[] nums1 = Arrays.copyOfRange(nums, 0, n - 1);
        //int[] dp1 = new int[n - 1];
        //Arrays.fill(dp1, -1);
        int temp1 = helper(nums1);

        int[] nums2 = Arrays.copyOfRange(nums, 1, n);
        //int[] dp2 = new int[n - 1];
        //Arrays.fill(dp2, -1);
        int temp2 = helper(nums2);

        return Math.max(temp1, temp2);
    }
}