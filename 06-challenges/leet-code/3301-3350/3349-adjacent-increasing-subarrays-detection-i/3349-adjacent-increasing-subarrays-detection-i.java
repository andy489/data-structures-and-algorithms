// https://leetcode.com/problems/adjacent-increasing-subarrays-detection-i/

// Solution: Precompute Run Lengths — O(n) time, O(n) space
class Solution {
    public boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
        int n = nums.size();
        int[] inc = new int[n];
        inc[0] = 1;
        for (int i = 1; i < n; i++) {
            inc[i] = nums.get(i) > nums.get(i - 1) ? inc[i - 1] + 1 : 1;
        }
        for (int a = 0; a + 2 * k <= n; a++) {
            if (inc[a + k - 1] >= k && inc[a + 2 * k - 1] >= k) {
                return true;
            }
        }
        return false;
    }
}
