class Solution {
    public int findDuplicate(int[] nums) {
        while(nums[0]!=nums[nums[0]])
        {
        int temp=nums[0];
        nums[0]=nums[temp];
        nums[temp]=temp; 
        }
        return nums[0];
    }
}