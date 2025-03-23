class Solution {
    void swap(int a,int b,int nums[])
    {
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }
    public void nextPermutation(int[] nums) {
        int idx=-1;
        int n=nums.length;
        for(int i=n-2;i>=0;i--)
        {
            if(nums[i]<nums[i+1])
            {
                idx=i;
                break;
            }
        }
        if(idx==-1){
        Arrays.sort(nums);
        return;
        }
       for(int i=n-1;i>idx;i--)
       {
        if(nums[i]>nums[idx])
        {
            swap(i,idx,nums);
            break;
        }
       }
       Arrays.sort(nums,idx+1,nums.length);
    }
}