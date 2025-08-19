class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long total=0;
        int l=0;
        int n=nums.length;
        //int len;
        for(int r=0;r<n;r++)
        {
            if(nums[r]!=0)
            {
             int len=r-l;
             if(len>0)
             total+=(1L * len * (len + 1)) / 2;  
             l=r+1; 
            }
        }
        int len=n-l;
        if(len>0)
        total+=(1L * len * (len + 1)) / 2;
        return total;
    }
}