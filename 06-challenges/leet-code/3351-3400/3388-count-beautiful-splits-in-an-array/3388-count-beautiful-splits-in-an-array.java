// https://leetcode.com/problems/count-beautiful-splits-in-an-array/

// Solution: Z-Function (LCP Arrays) — O(n^2) time, O(n^2) space
class Solution {
    public int beautifulSplits(int[] nums) {
        int n = nums.length;
        // lcp[i][j] = LCP length of nums[i..] and nums[j..]
        int[][] lcp = new int[n + 1][n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (nums[i] == nums[j]) {
                    lcp[i][j] = lcp[i + 1][j + 1] + 1;
                }
            }
        }

        int count = 0;
        for (int i = 1; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int len1 = i;       // nums1 length
                int len2 = j - i;   // nums2 length
                int len3 = n - j;   // nums3 length
                // Condition A: nums1 is prefix of nums2
                boolean condA = len1 <= len2 && lcp[0][i] >= len1;
                // Condition B: nums2 is prefix of nums3
                boolean condB = len2 <= len3 && lcp[i][j] >= len2;
                if (condA || condB) {
                    count++;
                }
            }
        }
        return count;
    }
}
