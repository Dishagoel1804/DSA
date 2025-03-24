class Solution {
    public int majorityElement(int[] nums) {
        if(nums.length==1)
        return nums[0];
       int m=nums.length/2;
       Arrays.sort(nums);
       int c=1;
       for(int i=0;i<nums.length-1;i++)
       {
        if(nums[i]==nums[i+1]){
        c++;
        if(c>m)
        return nums[i];
        }
        else c=1;
       }
       return -1;
    }
}