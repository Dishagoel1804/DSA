class Solution {
    public int maxDifference(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int a1=Integer.MIN_VALUE;
        int a2=Integer.MAX_VALUE;
        int a3=Integer.MIN_VALUE;
        int a4=Integer.MAX_VALUE;
        for(Map.Entry<Character,Integer> entry:map.entrySet())
        {
            if(entry.getValue()%2!=0)
            a1=Math.max(a1,entry.getValue());
            if(entry.getValue()%2==0)
            a2=Math.min(a2,entry.getValue());
            if(entry.getValue()%2==0)
            a3=Math.max(a3,entry.getValue());
            if(entry.getValue()%2!=0)
            a4=Math.min(a4,entry.getValue());   
        }
        int diff=a1-a2;
        int diff1=a3-a4;
        return diff;
    }
}