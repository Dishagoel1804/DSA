class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int B[]=new int[k];
        int min=Integer.MAX_VALUE;
        if(k==1)
        return 0;
        for(int i=0;i<=nums.length-k;i++)
        {
            min=Math.min(min,nums[i+k-1]-nums[i]);
        }
        return min;
    }
}