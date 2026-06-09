class Solution {
    public long maxTotalValue(int[] nums, int k) {
        Arrays.sort(nums);
        long a=nums[0];
        long b=nums[nums.length-1];
        return (b-a)*k; 
    }
}