// https://leetcode.com/problems/find-indices-with-index-and-value-difference-ii/

// Solution: Two Pointers with Min/Max Tracking — O(n) time, O(1) space
class Solution {
    public int[] findIndices(int[] nums, int indexDifference, int valueDifference) {
        int minIdx = 0, maxIdx = 0;
        for (int j = indexDifference; j < nums.length; j++) {
            int i = j - indexDifference;
            if (nums[i] < nums[minIdx]) {
                minIdx = i;
            }
            if (nums[i] > nums[maxIdx]) {
                maxIdx = i;
            }
            if (nums[j] - nums[minIdx] >= valueDifference) {
                return new int[]{minIdx, j};
            }
            if (nums[maxIdx] - nums[j] >= valueDifference) {
                return new int[]{maxIdx, j};
            }
        }
        return new int[]{-1, -1};
    }
}
