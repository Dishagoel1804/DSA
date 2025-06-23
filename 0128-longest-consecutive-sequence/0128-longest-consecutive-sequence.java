import java.util.Arrays;

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        Arrays.sort(nums);

        int max = 1;
        int currStreak = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                continue; // skip duplicates
            } else if (nums[i] == nums[i - 1] + 1) {
                currStreak++;
            } else {
                max = Math.max(max, currStreak);
                currStreak = 1;
            }
        }

        return Math.max(max, currStreak);
    }
}
