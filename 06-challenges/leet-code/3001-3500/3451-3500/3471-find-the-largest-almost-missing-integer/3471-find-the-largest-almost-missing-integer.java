// https://leetcode.com/problems/find-the-largest-almost-missing-integer/

// Solution: Count Subarray Appearances — O(n) time, O(n) space
class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> subArrayCount = new HashMap<>();
        for (int start = 0; start <= n - k; start++) {
            Set<Integer> seen = new HashSet<>();
            for (int j = start; j < start + k; j++) {
                seen.add(nums[j]);
            }
            for (int v : seen) {
                subArrayCount.merge(v, 1, Integer::sum);
            }
        }
        int ans = -1;
        for (Map.Entry<Integer, Integer> e : subArrayCount.entrySet()) {
            if (e.getValue() == 1) {
                ans = Math.max(ans, e.getKey());
            }
        }
        return ans;
    }
}
