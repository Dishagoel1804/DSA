class Solution {
    public int maxFreqSum(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int max=0;
        int max1=0;
        for(Map.Entry<Character,Integer> entry : map.entrySet())
        {
            if(entry.getKey()=='a' || entry.getKey()=='e' || entry.getKey()=='i' || entry.getKey()=='o' || entry.getKey()=='u')
            max=Math.max(max,entry.getValue());
            else
            max1=Math.max(max1,entry.getValue());
        }
        return max+max1;
    }
}