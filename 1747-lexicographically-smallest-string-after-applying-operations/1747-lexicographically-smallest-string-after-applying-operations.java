class Solution {
    String ans;
    Set<String> vis;
    int addv,rotv;
    public String findLexSmallestString(String s, int a, int b) {
        ans=s;
        vis=new HashSet<>();
        addv=a;
        rotv=b;
        dfs(s);
        return ans;
    }
    void dfs(String s)
    {
        if(vis.contains(s))
        return;
        vis.add(s);

        if(s.compareTo(ans)<0)
        ans=s;

        String added=Add(s,addv);
        dfs(added);

        String rotated=Rotate(s,rotv);
        dfs(rotated);
    }
    String Add(String s,int a)
    {
        char[] c=s.toCharArray();
        for(int i=1;i<s.length();i+=2)
        {
            int digit=(c[i]-'0'+a)%10;
            c[i]=(char)('0'+digit);
        }
        return new String(c);
    }
    String Rotate(String s,int b)
    {
        int n=s.length();
        b%=n;
        return s.substring(n-b)+s.substring(0,n-b);
    }
}