class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n=nums.length;
     int A[]=new int[n-k+1];   
     for(int i=0;i<A.length;i++)
     {
        HashMap<Integer,Integer> map=new HashMap<>();
        //int s=0;
        for(int j=i;j<=i+k-1;j++)
        {
            int a=nums[j];
            map.put(a,map.getOrDefault(a,0)+1);
        }
        List<int[]> freq=new ArrayList<>();
            for(Map.Entry<Integer,Integer> entry:map.entrySet())
            {
                freq.add(new int[]{entry.getValue(),entry.getKey()});
            }
            freq.sort((a,b)-> b[0]!=a[0] ? b[0]-a[0]:b[1]-a[1]);
            int s=0;
            for(int j=0;j<x && j<freq.size();++j)
            {
                s+=freq.get(j)[0]*freq.get(j)[1];
            }
            A[i]=s;
     }
     return A;
    }
}