class Solution {
    public long distributeCandies(int n, int limit) {
        
        int r;
        long ans=0;
        for(int i=0;i<=limit;i++)
        {
            r=n-i;
            if((r<0)||(r>2*limit))
            continue;
            int j=Math.max(0,r-limit);
            int k=Math.min(r,limit);
            if(j<=k)
            ans+=k-j+1;
        }
        return ans;
    }
}