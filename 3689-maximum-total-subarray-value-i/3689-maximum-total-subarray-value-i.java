class Solution {
    public long maxTotalValue(int[] nums, int k) {
        Arrays.sort(nums);
        int a=nums[0];
        int b=nums[nums.length-1];
        return (long)(b-a)*k; 
    }
}