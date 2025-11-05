class Solution {
    public int maxDiff(int num) {
        String s=""+num;int i=0;int p=0;char c;
        while(i<s.length())
        {
            c=s.charAt(i);
            if(c=='9')
            i++;
            else
            {
                p=i;
                break;
            }
        }
        c=s.charAt(p);
        s=s.replace(c,'9');
        int a=Integer.parseInt(s);
         s=""+num;
         if(s.matches("1+"))
         s.replace('1','1');
        else if(s.charAt(0)!='1')
        s=s.replace(s.charAt(0),'1');
        else
        {
            i=1;p=1;
            while(i<s.length())
        {
            c=s.charAt(i);
            if(c=='0' || c=='1')
            i++;
            else
            {
                p=i;
                break;
            }
        }
         c=s.charAt(p);
        s=s.replace(c,'0');
        }
        int b=Integer.parseInt(s);
        return a-b;
    }
}