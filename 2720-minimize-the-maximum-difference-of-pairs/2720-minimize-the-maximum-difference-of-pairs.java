class Solution {
    public int minimizeMax(int[] nums, int p) {
        Arrays.sort(nums);int ans;
        int l=0,u=nums[nums.length-1]-nums[0],mid;
        ans=u;
        while(l<=u)
        {
            mid=(l+u)/2;
            if(canform(nums,p,mid))
            {
                ans=mid;
                u=mid-1;
            }
            else
            l=mid+1;
        }
            return ans;
        }
        private boolean canform(int[] nums, int p, int diff) {
        int count = 0;
        for (int i = 1; i < nums.length && count < p; i++) {
            if (nums[i] - nums[i - 1] <= diff) {
                count++;
                i++; 
            }
        }
        return count >= p;
    }
}