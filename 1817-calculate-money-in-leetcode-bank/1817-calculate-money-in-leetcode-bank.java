class Solution {
    public int totalMoney(int n) {
        int a;int s=0;
        int i,p;
        if(n<7)
        {
            return (int)((n*(n+1))/2);
        }
        if(n%7==0)
        {
        a=n/7;
        for(i=1;i<=a;i++)
        {
            p=i;
            for(int j=1;j<=7;j++)
            {
                s+=p;p++;
            }
        }
        
        }
        else {
        a=n/7+1;
        for(i=1;i<a;i++)
        {
            p=i;
            for(int j=1;j<=7;j++)
            {
                s+=p;
                p++;
            }
        }
        p=i;
        for(i=1;i<=(n%7);i++)
        {
            s+=p;p++;
        }
        }
        
        return s;
    }
}