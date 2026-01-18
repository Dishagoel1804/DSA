class Solution {
    public int sumFourDivisors(int[] nums) {
        int summ=0;
        for(int i=0;i<nums.length;i++)
        {
            int a=nums[i];int c=0;int sum=0;
            for(int j=1;j<=a;j++)
            {
                if(a%j==0){
                c++;
                sum+=j;
                }
                if(c>4)
                {
                    sum=0;
                    break;
                }
            }
            if(c==4)
            summ+=sum;
        }
    return summ;
    }
}