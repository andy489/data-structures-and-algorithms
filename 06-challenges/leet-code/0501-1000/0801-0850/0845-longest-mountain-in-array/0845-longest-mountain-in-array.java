// https://leetcode.com/problems/longest-mountain-in-array/

// Solution: Two Pass — O(n) time, O(n) space
class Solution {
    public int longestMountain(int[] arr) {
        int n = arr.length;
        int[] up = new int[n];
        int[] down = new int[n];
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) {
                up[i] = up[i - 1] + 1;
            }
        }
        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > arr[i + 1]) {
                down[i] = down[i + 1] + 1;
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (up[i] > 0 && down[i] > 0) {
                ans = Math.max(ans, up[i] + down[i] + 1);
            }
        }
        return ans;
    }
}
