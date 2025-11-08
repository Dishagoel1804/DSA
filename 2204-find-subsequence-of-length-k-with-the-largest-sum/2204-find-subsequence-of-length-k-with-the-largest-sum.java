class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        int[] B = nums.clone();   // keep original order
        
        // sort a copy to find k largest
        Arrays.sort(nums);
        
        // store k largest values
        List<Integer> list = new ArrayList<>();
        for (int i = n - k; i < n; i++) {
            list.add(nums[i]);
        }

        int[] result = new int[k];
        int idx = 0;
        for (int val : B) {
            if (list.contains(val)) {
                result[idx++] = val;
                list.remove((Integer) val); // remove only one occurrence
                if (idx == k) break;
            }
        }

        return result;
    }
}
