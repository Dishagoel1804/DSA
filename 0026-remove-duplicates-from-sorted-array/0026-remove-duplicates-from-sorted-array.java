class Solution {
    public int removeDuplicates(int[] nums) {
        //int A[]=new int[nums.length];
        for(int i=0;i<nums.length-1;i++)
        {
            for(int j=i+1;j<nums.length;j++)
            {
                if(nums[i]==nums[j])
                nums[j]=-101;
            }
        }
        int a=0;
        for(int i=0;i<nums.length;i++)
        {
            if(nums[i]!=-101)
            {
                nums[a]=nums[i];
                a++;
            }
        }
        return a;
    }
}