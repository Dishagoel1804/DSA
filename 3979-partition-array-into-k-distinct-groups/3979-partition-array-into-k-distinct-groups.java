class Solution {
    public boolean partitionArray(int[] nums, int k) {
        if(nums.length % k!=0)
        return false;
        int g=nums.length/k;
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        int max=Integer.MIN_VALUE;
        for(Map.Entry<Integer,Integer> entry:map.entrySet())
        {
            if(entry.getValue()>max)
            {
                max=entry.getValue();
            }
        }
        return max<=g;
    }
}