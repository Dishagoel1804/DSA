class Solution {
    public int reverse(int x) {
        if(x==0)
        return 0;
        String s=""+x;
        String s1=s;
        if(s1.charAt(0)=='-')
        {
            s=s1.substring(1);
        }
        StringBuilder ob=new StringBuilder(s);
        ob.reverse();
        s=ob.toString();
        if(s.charAt(0)=='0')
        s=s.substring(1);
        if(s1.charAt(0)=='-')
        {
            s='-'+s;
        }
        try {
            int a = Integer.parseInt(s);
            return a;
        } catch (NumberFormatException e) {
            return 0; 
        }
    }
}