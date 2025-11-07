class Solution {
    public int minimumDeletions(String word, int k) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(char c:word.toCharArray())
        {
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int n=word.length();
        for(int a:map.values())
        {
            int d=0;
            for(int b:map.values())
            {
                if(a>b)
                d+=b;
                else if(b>a+k)
                d+=b-(a+k);
            }
            n=Math.min(n,d);
        }
        return n;
    }
}