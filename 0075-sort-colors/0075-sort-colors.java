class Solution {
    public void sortColors(int[] nums) {
        int i,j,t;
        for(i=0;i<nums.length-1;i++)
        {
            for(j=0;j<nums.length-1-i;j++)
            {
                if(nums[j]>nums[j+1])
                {
                    t=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=t;
                }
            }
        }
    }
}