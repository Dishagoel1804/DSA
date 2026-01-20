class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int res[]=new int[nums.size()];
        for(int i=0;i<nums.size();i++)
        {
            int a=nums.get(i);
            if(a==2)
            res[i]=-1;
            else
            {
                String b=Integer.toBinaryString(a);int k=0;
                for(int j=b.length()-1;j>=0;j--)
                {
                    if(b.charAt(j)=='1')
                    k++;
                    else
                    break;
                }
                res[i]=a-(int)Math.pow(2,(k-1));
            }
        }
        return res;
    }
}