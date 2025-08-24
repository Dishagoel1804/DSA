class Solution {
    int gcd(int x,int y)
    {
        if(x==0)
        return y;
        return gcd(y%x,x);
    }
    public int gcdOfOddEvenSums(int n) {
        int so=0;
        int se=0;
        for(int i=1;i<=n*2;i++)
        {
            if(i%2!=0)
            so+=i;
            else
            se+=i;
        }
        int a=Math.max(so,se);
        int b=Math.min(so,se);
        return gcd(a,b);
    }
}