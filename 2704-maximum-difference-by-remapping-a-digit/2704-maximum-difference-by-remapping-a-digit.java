class Solution {
    public int minMaxDifference(int num) {
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
        s=s.replace(s.charAt(0),'0');
        int b=Integer.parseInt(s);
        return a-b;
    }
}