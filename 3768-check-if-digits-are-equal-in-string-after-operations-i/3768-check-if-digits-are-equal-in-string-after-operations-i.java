class Solution {
    String add(String s)
    {
        String s1="";
        for(int i=0;i<s.length()-1;i++)
        {
            int a=(s.charAt(i)+s.charAt(i+1))%10;
            s1=s1+a;
        }
        return s1;
    }
    public boolean hasSameDigits(String s) {
        while(s.length()!=2)
        {
            s=add(s);
        }
        if(s.charAt(0)==s.charAt(1))
        return true;
        return false;
    }
}