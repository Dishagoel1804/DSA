class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int i,j;
        int A[]=new int[nums.length];
        int a=0;
        for(i=0;i<nums.length;i++)
        {
            if(nums[i]<pivot){
            A[a]=nums[i];
            a++;
            }
        }
        for(i=0;i<nums.length;i++)
        {
            if(nums[i]==pivot){
            A[a]=nums[i];
            a++;
            }
        }
        for(i=0;i<nums.length;i++)
        {
            if(nums[i]>pivot){
            A[a]=nums[i];
            a++;
            }
        }
        for(i=0;i<nums.length;i++)
        {
            nums[i]=A[i];
        }
        return nums;
    }
}