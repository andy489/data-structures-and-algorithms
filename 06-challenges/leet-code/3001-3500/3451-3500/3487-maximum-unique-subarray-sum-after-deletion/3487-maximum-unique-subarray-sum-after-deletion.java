// https://leetcode.com/problems/maximum-unique-subarray-sum-after-deletion/

// Solution: Greedy — O(n) time, O(n) space
class Solution {
    public int maxSum(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        int sum = 0;
        boolean hasPositive = false;
        for (int x : nums) {
            if (x > 0 && seen.add(x)) {
                sum += x;
                hasPositive = true;
            }
        }
        if (!hasPositive) {
            int max = nums[0];
            for (int x : nums) {
                if (x > max) {
                    max = x;
                }
            }
            return max;
        }
        return sum;
    }
}
