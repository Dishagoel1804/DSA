class Solution {
    public int largestAltitude(int[] gain) {
        int a=0,max=0;
        for(int i=0;i<gain.length;i++)
        {
            a+=gain[i];
            //total+=a;
            if(max<a)
            max=a;
        }
        return max;
    }
}