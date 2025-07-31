class Solution {
    int c=0;
    void f(int txor,int nums[],int i,int curr)
    {
        if(i==nums.length)
        {
            if(curr==txor)
            c++;
            return;
        }
        f(txor,nums,i+1,nums[i]|curr);
        f(txor,nums,i+1,curr);
        //return c;
    }
    public int countMaxOrSubsets(int[] nums) {
        int n=nums.length;
        int txor=0;
        for(int i=0;i<n;i++)
        {
            txor=txor|nums[i];
        }
        f(txor,nums,0,0);
        return c;
    }
}