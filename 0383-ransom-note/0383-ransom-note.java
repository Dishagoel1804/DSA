class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int k;
        for(int i=0;i<ransomNote.length();i++)
        {
            char c=ransomNote.charAt(i);k=0;
            if(magazine.indexOf(c)==-1)
            return false;
            magazine=magazine.replaceFirst(Character.toString(c)," ");
        }
        return true;
    }
}