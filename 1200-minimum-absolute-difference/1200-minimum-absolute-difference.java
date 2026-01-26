class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> list1=new ArrayList<>();
        Arrays.sort(arr);
        int min=Integer.MAX_VALUE;
        for(int i=0;i<arr.length-1;i++)
        {
            int diff=arr[i+1]-arr[i];
            min=Math.min(min,diff);
        }
        int j=0;
        for(int i=0;i<arr.length-1;i++)
        {
            if((arr[i+1]-arr[i])==min)
            {
                List<Integer> list=new ArrayList<>();
                list.add(arr[i]);
                list.add(arr[i+1]);
                list1.add(list);
            }
            
        }
        return list1;
    }
}