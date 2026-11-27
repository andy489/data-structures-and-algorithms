// https://leetcode.com/problems/split-the-array/

// Solution: Frequency Check — O(n) time, O(n) space
class Solution {
    public boolean isPossibleToSplit(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : nums) { freq.merge(x, 1, Integer::sum); }
        for (int f : freq.values()) { if (f > 2) { return false; } }
        return true;
    }
}
