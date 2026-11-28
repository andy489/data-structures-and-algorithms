// https://leetcode.com/problems/subarrays-distinct-element-sum-of-squares-i/

// Solution: Brute Force with HashSet — O(n^3) time, O(n) space
class Solution {
    public int sumCounts(List<Integer> nums) {
        int n = nums.size();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            Set<Integer> seen = new HashSet<>();
            for (int j = i; j < n; j++) {
                seen.add(nums.get(j));
                int d = seen.size();
                ans += d * d;
            }
        }
        return ans;
    }
}
