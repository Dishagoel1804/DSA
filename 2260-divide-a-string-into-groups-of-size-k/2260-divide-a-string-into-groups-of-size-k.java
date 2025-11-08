class Solution {
    public String[] divideString(String s, int k, char fill) {
        int n=s.length();int a;
        a=(n+k-1)/k;
        String A[]=new String[a];int p=0;
        for(int i=0;i<n;i+=k)
        {
            String s1="";
            if(i+k<=n)
            s1=s.substring(i,i+k);
            else
            {
                s1=s.substring(i);
                while(s1.length()<k)
                s1=s1+fill;
            }
            A[p]=s1;
            p++;
        }
        return A;
    }
}