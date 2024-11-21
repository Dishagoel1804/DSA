class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> list=new ArrayList<>();
        solve("",0,0,n,list);
        return list;
    }
    public void solve(String c,int open,int close,int total,List<String> list)
    {
        if(c.length()==2*total)
        {
            list.add(c);
            return;
        }
        if(open<total)
        solve(c+"(",open+1,close,total,list);
        if(close<open)
        solve(c+")",open,close+1,total,list);
    }
}