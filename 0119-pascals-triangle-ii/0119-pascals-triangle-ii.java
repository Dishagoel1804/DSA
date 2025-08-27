class Solution {
    public List<Integer> getRow(int rowIndex) {
        int numRows=rowIndex+1;
        List<List<Integer>> list=new ArrayList<>();
        ArrayList<Integer> list1=new ArrayList<>();
        list1.add(1);
        list.add(list1);
        if(numRows==1)
        return list.get(rowIndex);
        ArrayList<Integer> list2=new ArrayList<>();
        list2.add(1);
        list2.add(1);
        list.add(list2);
        if(numRows==2)
        return list.get(rowIndex);
        for(int i=3;i<=numRows;i++)
        {
            ArrayList<Integer> list3=new ArrayList<>();
            list3.add(0,1);
            int a=0;
           for(int j=1;j<i-1;j++)
           {
            int s=list2.get(a)+list2.get(a+1);
            list3.add(j,s);
            a++;
           }
           list3.add(1);
           list.add(list3);
           list2=list3;
        }
        return list.get(rowIndex);
    }
}