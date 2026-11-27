// https://leetcode.com/problems/minimum-absolute-sum-difference/

// Solution: Sorted Set + Binary Search — O(n log n) time, O(n) space
class Solution {
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] sorted1 = nums1.clone();
        Arrays.sort(sorted1);
        long total = 0, maxSave = 0;
        long mod = 1_000_000_007L;
        for (int i = 0; i < n; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            total += diff;
            int pos = Arrays.binarySearch(sorted1, nums2[i]);
            if (pos < 0) {
                pos = -pos - 1;
            }
            if (pos < n) {
                maxSave = Math.max(maxSave, diff - Math.abs(sorted1[pos] - nums2[i]));
            }
            if (pos > 0) {
                maxSave = Math.max(maxSave, diff - Math.abs(sorted1[pos - 1] - nums2[i]));
            }
        }
        return (int) ((total - maxSave) % mod);
    }
}
