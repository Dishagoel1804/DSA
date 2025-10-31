class Solution {
    public int[] getSneakyNumbers(int[] nums) {
        int n[]=new int[2];
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            int a=nums[i];
            map.put(a,map.getOrDefault(a,0)+1);
        }
        int p=0;
        for(Map.Entry<Integer,Integer> entry:map.entrySet())
        {
            if(entry.getValue()>1)
            {
            n[p]=entry.getKey();p++;
            }
        }
        return n;
    }
}