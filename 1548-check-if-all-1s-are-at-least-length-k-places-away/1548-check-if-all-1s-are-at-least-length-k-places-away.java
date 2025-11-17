class Solution {
    public boolean kLengthApart(int[] nums, int k) {
        int p=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]==1){
            p=i;
            break;
            }
        }
        for(int i=p+1;i<nums.length;i++)
        {
            if(nums[i]==1)
            {
                if((i-p)<=k)
                return false;
                p=i;
            }
        }
        return true;
    }
}