class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> list=new ArrayList<>();
        List<Integer> list1=new ArrayList<>();
        for(int i=0;i<nums.length;i++)
        {
            if(key==nums[i])
            list1.add(i);
        }
        for(int i=0;i<nums.length;i++)
        {
            for(int j=0;j<list1.size();j++)
            {
                if(Math.abs(i-list1.get(j))<=k)
                {
                    list.add(i);
                    break;
                }
            }
        }
        return list;
    }
}