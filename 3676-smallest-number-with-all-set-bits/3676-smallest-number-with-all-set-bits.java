class Solution {
    int binaryD(String s)
    {
        int b=0;
        for(int i=0;i<s.length();i++)
        {
            b+=(int)Math.pow(2,i);
        }
        return b;
    }
    String DecimalB(int n)
    {
        String s="";
        while(n!=0)
        {
            int a=n%2;
            s=a+s;
            n=n/2;
        }
        return s;
    }
    public int smallestNumber(int n) {
        String s1=DecimalB(n);
        s1=s1.replace('0','1');
        return binaryD(s1);
    }
}