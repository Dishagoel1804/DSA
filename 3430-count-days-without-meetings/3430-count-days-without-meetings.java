class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));
        ArrayList<ArrayList<Integer>> list=new ArrayList<>();
        ArrayList<Integer> list1=new ArrayList<>();
        list1.add(meetings[0][0]);
        list1.add(meetings[0][1]);
        list.add(list1);
        int j=0;
        for(int i=1;i<meetings.length;i++)
        {
            if(list.get(j).get(1)>=meetings[i][0])
            {
                list.get(j).set(1,(Math.max(list.get(j).get(1),meetings[i][1])));
            }
            else
            {
                ArrayList<Integer> list2=new ArrayList<>();
                list2.add(meetings[i][0]);
                list2.add(meetings[i][1]);
                list.add(list2);
                j++;
            }
        }
        System.out.println(list);
        int c=0;
        int i;
        if(list.size()==1)
        {
            if(list.get(0).get(0)>1)
        c+=list.get(0).get(0)-1;
        if(list.get(0).get(1)<days)
        c+=days-list.get(0).get(1);
        return c;
        }
        if(list.get(0).get(0)>1){
        c+=list.get(0).get(0)-1;
        }
        if(list.get(1).get(0)>list.get(0).get(1))
        c+=(list.get(1).get(0)-list.get(0).get(1))-1;
        for(i=1;i<list.size()-1;i++)
        {
           int sa=list.get(i).get(0);
           int fa=list.get(i).get(1);
           int sb=list.get(i+1).get(0);
           int fb=list.get(i+1).get(1);
           
           c=c+sb-fa-1;
        }
        if(list.get(i).get(1)<days)
        c+=days-list.get(i).get(1);
        return c;
    }
}