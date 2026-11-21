// https://leetcode.com/problems/longest-consecutive-sequence/

// Solution: Hash Set — O(n) time, O(n) space
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) set.add(n);
        int ans = 0;
        for (int n : set) {
            if (!set.contains(n - 1)) {
                int len = 1;
                while (set.contains(n + len)) len++;
                ans = Math.max(ans, len);
            }
        }
        return ans;
    }
}
