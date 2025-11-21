class Solution {
    public int countPalindromicSubsequence(String s) {
        int ans=0;
        int n=s.length();
        for(char c='a';c<='z';c++)
        {
            int first=-1,last=-1;
            for(int i=0;i<n;i++)
            {
                if(s.charAt(i)==c)
                {
                    if(first==-1)
                    first=i;
                    last=i;
                }    
            }
                if(first==-1 || first==last)
                continue;
                boolean seen[]=new boolean[26];
                for(int i=first+1;i<last;i++)
                seen[s.charAt(i)-'a']=true;
            for(boolean b:seen)
            {
                if(b)
                ans++;
            }
        }
        return ans;
    }
}