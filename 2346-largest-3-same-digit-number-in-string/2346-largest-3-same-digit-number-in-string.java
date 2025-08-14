class Solution {
    public String largestGoodInteger(String num) {
        int c=0;int p=-1;
        for(int i=0;i<num.length()-1;i++)
        {
            if(num.charAt(i)==num.charAt(i+1))
            c++;
            if(num.charAt(i)!=num.charAt(i+1))
            c=0;
            if(c==2)
            {
                p=Math.max((num.charAt(i)-'0'),p);
            }
        }
        if(p!=-1)
        return ""+p+p+p+"";
        return "";
    }
}