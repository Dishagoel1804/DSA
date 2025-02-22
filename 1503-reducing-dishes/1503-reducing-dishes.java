import java.lang.Math;
class Solution {
    public int maxSatisfaction(int[] satisfaction) {
      Arrays.sort(satisfaction);
      int total=0,max=0,sum=0;
      int n=satisfaction.length;
      for(int i=n-1;i>=0;i--)
      {
        sum+=satisfaction[i];
        total+=sum;
        max=Math.max(max,total);
      }
      return max;
    }
}