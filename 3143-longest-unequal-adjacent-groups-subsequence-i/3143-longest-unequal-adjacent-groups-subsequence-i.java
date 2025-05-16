class Solution {
    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        int n=groups.length;
        List<String> list=new ArrayList<>();
        if(n==0)
        return list;
        list.add(words[0]);
        int s=groups[0];
        for(int i=1;i<n;i++)
        {
            if(s!=groups[i])
            {
                list.add(words[i]);
                s=groups[i];
            }
        }
        return list;
    }
}