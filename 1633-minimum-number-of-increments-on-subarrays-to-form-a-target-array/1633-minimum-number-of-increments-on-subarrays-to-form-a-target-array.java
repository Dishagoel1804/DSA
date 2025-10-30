class Solution {
    public int minNumberOperations(int[] target) {
        int c=target[0];
        for(int i=1;i<target.length;i++)
        {
            if((target[i]-target[i-1])>0)
            c+=(target[i]-target[i-1]);
        }
        return c;
    }
}