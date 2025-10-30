class Solution {
    public String answerString(String word, int numFriends) {
        if(numFriends==1)
        return word;
        int n=word.length();
        int minLen = word.length() - numFriends + 1;
        String ans="";
        for(int i=0;i<n;i++)
        {
            String s=word.substring(i,Math.min(n,i+minLen));
            if(s.compareTo(ans)>0)
            ans=s;
        }
        return ans;
    }
}