class Solution {
    public String triangleType(int[] nums) {
        String s1="";
        if(nums[0]==nums[1]&&nums[1]==nums[2])
        s1="equilateral";

         else if(nums[0]!=nums[1]&&nums[1]!=nums[2]&&nums[0]!=nums[2])
        {
            if(nums[0]+nums[1]>nums[2]&&nums[0]+nums[2]>nums[1]&&nums[1]+nums[2]>nums[0])
        s1="scalene";
        else
        s1="none";
        }

        else if(nums[0]==nums[1]||nums[1]==nums[2]||nums[0]==nums[2])
        {
            if(nums[0]+nums[1]>nums[2]&&nums[0]+nums[2]>nums[1]&&nums[1]+nums[2]>nums[0])
            s1="isosceles";
            else
            s1="none";
        }

        return s1;
    }
}