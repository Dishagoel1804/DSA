class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n=nums.length;
        if(n==0)
        return new ArrayList<>();
        Arrays.sort(nums);
        int dp[]=new int[n];
        int prev[]=new int[n];
        Arrays.fill(dp,1);
        Arrays.fill(prev,-1);
        int maxIdx=0;
        for(int i=0;i<nums.length;i++)
        {
            for(int j=0;j<i;j++)
            {
                if(nums[i]%nums[j]==0)
                {
                    if(dp[j]+1>dp[i])
                    {
                        dp[i]=dp[j]+1;
                        prev[i]=j;
                    }
                }
            }
            if(dp[i]>dp[maxIdx])
            maxIdx=i;
        }
        List<Integer> result = new ArrayList<>();
        int k = maxIdx;
        while (k != -1) {
            result.add(nums[k]);
            k = prev[k];
        }
        Collections.reverse(result); 
        return result;
    }
}