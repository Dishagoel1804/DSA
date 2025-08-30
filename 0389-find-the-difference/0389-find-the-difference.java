class Solution {
    public char findTheDifference(String s, String t) {
        for(int i=0;i<s.length();i++)
        {
            char c=s.charAt(i);
            t=t.replaceFirst(Character.toString(c),"");
        }
        return t.charAt(0);
    }
}