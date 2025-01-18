import java.lang.Math;

class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int a,max,i,n;
        max=0;n=nums.length;
        for(i=0;i<nums.length;i++)
        {
            if(i!=nums.length-1)
            a=Math.abs(nums[i]-nums[(i+1)]);
            else
            a=Math.abs(nums[0]-nums[nums.length-1]);
            if(max<a)
                max=a;
        }
        return max;
    }
}