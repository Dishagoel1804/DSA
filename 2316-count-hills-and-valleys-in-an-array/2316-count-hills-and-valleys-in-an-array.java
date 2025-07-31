class Solution {
    public int countHillValley(int[] nums) {
        int n=nums.length;
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<n-1;i++)
        {
            if(nums[i]!=nums[i+1])
            list.add(nums[i]);
        }
        list.add(nums[n-1]);int c=0;
        for(int i=1;i<list.size()-1;i++)
        {
            if((list.get(i)>list.get(i-1) && list.get(i)>list.get(i+1))||(list.get(i)<list.get(i-1) && list.get(i)<list.get(i+1)))
            c++;
        }
        return c;
    }
}