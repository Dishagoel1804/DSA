class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int a=0;
        for(int i=m;i<nums1.length;i++)
        {
            nums1[i]=nums2[a];
            a++;
        }
        int min;
        for(int i=0;i<nums1.length;i++)
        {
            min=i;
            for(int j=i+1;j<nums1.length;j++)
            {
                if(nums1[min]>nums1[j])
                {
                    min=j;
                }
            }
            int temp=nums1[i];
            nums1[i]=nums1[min];
            nums1[min]=temp;
        }
    }
}