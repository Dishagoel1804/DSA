class Solution {
    public int countValidSelections(int[] nums) {
        int n=nums.length;
        int c=0;
        for(int i=0;i<n;i++)
        {
            if(nums[i]==0){
            if(isValid(nums,i,-1))
            c++;
            if(isValid(nums,i,1))
            c++;}
        }
        return c;
    }
    boolean isValid(int nums[],int start,int dir)
    {
        int n=nums.length;
        int curr=start;
        int arr[]=nums.clone();
        while(curr>=0 && curr<n)
        {
            if(arr[curr]==0)
            {
                curr+=dir;
            }
            else
            {
                arr[curr]--;
                dir*=-1;
                curr+=dir;
            }
        }
        for(int i=0;i<n;i++)
        {
            if(arr[i]!=0)
            return false;
        }
        return true;
    }
}