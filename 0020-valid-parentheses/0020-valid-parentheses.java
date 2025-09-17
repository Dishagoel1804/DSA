import java.util.*;
class Solution {
    public boolean isValid(String s) {
        Stack<Character> st=new Stack<>();
        int i=0;
        while(i<s.length())
        {
            char c=s.charAt(i);
            if(st.isEmpty())
            st.push(c);
            else if(c=='(' || c=='{' || c=='[')
            {
                st.push(c);
            }
            else
            {
                if(c==')' && st.peek()=='(')
                st.pop();
                else if(c=='}' && st.peek()=='{')
                st.pop();
                else if(c==']' && st.peek()=='[')
                st.pop();
                else
                st.push(c);
            }
            i++;
        }
        if(st.isEmpty())
        return true;
        return false;
    }
}