class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> list=new ArrayList<>();
        if(digits.length()==0)
        return list;
        HashMap<Character,String> map=new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        backtrack(digits,0,list,map,new StringBuilder());
        return list;
    }
    void backtrack(String digits,int i,List<String> list,HashMap<Character,String> map,StringBuilder sb)
    {
        if(i==digits.length()){
        list.add(sb.toString());
        return;}
        String curr=map.get(digits.charAt(i));
        for(int k=0;k<curr.length();k++)
        {
            sb.append(curr.charAt(k));
            backtrack(digits,i+1,list,map,sb);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}