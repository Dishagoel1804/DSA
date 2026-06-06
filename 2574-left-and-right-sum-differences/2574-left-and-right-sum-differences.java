import java.lang.Math;
class Solution {
    public int[] leftSum(int[] nums)
    {
        int A[]=new int[nums.length];A[0]=0;int j;
        for(int i=1;i<nums.length;i++)
        {
            int s=0;
            for(j=0;j<i;j++)
            {
                s+=nums[j];
            }
            A[i]=s;
        }
        return A;
    }
    public int[] rightSum(int[] nums)
    {
        int A[]=new int[nums.length];A[nums.length-1]=0;
        int i,j;
        for(i=0;i<nums.length-1;i++)
        {
            int s=0;
            for(j=i+1;j<nums.length;j++)
            {
                s+=nums[j];        
            }
            A[i]=s;
        }
        return A;
    }
    public int[] leftRightDifference(int[] nums) {
        int answer[]=new int[nums.length];
        int left[]=new int[nums.length];
        int right[]=new int[nums.length];
        left=leftSum(nums);
        right=rightSum(nums);
        for(int i=0;i<answer.length;i++)
        {
            answer[i]=Math.abs(left[i]-right[i]);
        }
        return answer;
    }
}