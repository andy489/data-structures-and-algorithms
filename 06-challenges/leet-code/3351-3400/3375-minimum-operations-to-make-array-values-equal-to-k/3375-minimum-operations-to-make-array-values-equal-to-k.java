// https://leetcode.com/problems/minimum-operations-to-make-array-values-equal-to-k/

// Solution: Count Distinct Values > k — O(n) time, O(n) space
class Solution {
    public int minOperations(int[] nums, int k) {
        Set<Integer> distinct = new HashSet<>();
        for (int x : nums) {
            if (x < k) {
                return -1;
            }
            if (x > k) {
                distinct.add(x);
            }
        }
        return distinct.size();
    }
}
