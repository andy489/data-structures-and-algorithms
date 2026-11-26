// https://leetcode.com/problems/maximum-number-of-non-overlapping-subarrays-with-sum-equals-target/

// Solution: Greedy Prefix Sum — O(n) time, O(n) space
class Solution {
    public int maxNonOverlapping(int[] nums, int target) {
        Set<Integer> seen = new HashSet<>();
        seen.add(0);
        int prefixSum = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            if (seen.contains(prefixSum - target)) {
                count++;
                seen.clear();
                seen.add(0);
                prefixSum = 0;
            } else {
                seen.add(prefixSum);
            }
        }
        return count;
    }
}
