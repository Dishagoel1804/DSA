class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        String[] words=text.split(" ");
        int c=0;
        boolean flag;
        if(brokenLetters.length()==0)
        return words.length;
        for(String word:words)
        {
            flag=true;
            for(int i=0;i<brokenLetters.length();i++)
            {
                char ch=brokenLetters.charAt(i);
                if(word.indexOf(ch)!=-1)
                {
                    flag=false;
                    break;
                }
            }
            if(flag==true)
            c++;
        }
        return c;
    }
}