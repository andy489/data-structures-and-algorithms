// https://leetcode.com/problems/minimum-deletions-to-make-array-beautiful/
class Solution {
    public int minDeletion(int[] nums) {
        int deletions = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if ((i - deletions) % 2 == 0 && nums[i] == nums[i + 1]) {
                deletions++;
            }
        }
        if ((nums.length - deletions) % 2 != 0) {
            deletions++;
        }
        return deletions;
    }
}
