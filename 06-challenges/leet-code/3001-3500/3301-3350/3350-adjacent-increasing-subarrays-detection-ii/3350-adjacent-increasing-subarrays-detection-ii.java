// https://leetcode.com/problems/adjacent-increasing-subarrays-detection-ii/

// Solution: Precompute Ending/Starting Run Lengths — O(n) time, O(n) space
class Solution {
    public int maxIncreasingSubarrays(List<Integer> nums) {
        int n = nums.size();
        // inc[i] = length of strictly increasing run ending at i
        int[] inc = new int[n];
        inc[0] = 1;
        for (int i = 1; i < n; i++) {
            inc[i] = nums.get(i) > nums.get(i - 1) ? inc[i - 1] + 1 : 1;
        }
        // startInc[i] = length of strictly increasing run starting at i
        int[] startInc = new int[n];
        startInc[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            startInc[i] = nums.get(i + 1) > nums.get(i) ? startInc[i + 1] + 1 : 1;
        }
        int ans = 0;
        for (int m = 1; m < n; m++) {
            ans = Math.max(ans, Math.min(inc[m - 1], startInc[m]));
        }
        return ans;
    }
}
