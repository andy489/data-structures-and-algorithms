// https://leetcode.com/problems/maximum-number-of-distinct-elements-after-operations/

// Solution: Greedy Sort — O(n log n) time, O(1) space
class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        java.util.Arrays.sort(nums);
        int count = 0;
        long prev = Long.MIN_VALUE;
        for (int x : nums) {
            long candidate = Math.max((long) x - k, prev + 1);
            if (candidate <= (long) x + k) {
                count++;
                prev = candidate;
            }
        }
        return count;
    }
}
