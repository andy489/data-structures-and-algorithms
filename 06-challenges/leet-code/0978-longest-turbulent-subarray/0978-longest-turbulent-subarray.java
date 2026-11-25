// https://leetcode.com/problems/longest-turbulent-subarray/

// Solution: Sliding Window — O(n) time, O(1) space
class Solution {
    public int maxTurbulenceSize(int[] arr) {
        int n = arr.length, ans = 1, cur = 1;
        for (int i = 1; i < n; i++) {
            int cmp = Integer.compare(arr[i], arr[i - 1]);
            if (cmp == 0) {
                cur = 1;
            } else if (i > 1 && Integer.compare(arr[i - 1], arr[i - 2]) * cmp > 0) {
                cur = 2;
            } else {
                cur++;
            }
            ans = Math.max(ans, cur);
        }
        return ans;
    }
}
