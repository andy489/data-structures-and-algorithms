// https://leetcode.com/problems/advantage-shuffle/

// Solution: Greedy (Sorted Assignment) — O(n log n) time, O(n) space
class Solution {
    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        Arrays.sort(nums1);
        Integer[] idx2 = new Integer[n];
        for (int i = 0; i < n; i++) {
            idx2[i] = i;
        }
        Arrays.sort(idx2, (a, b) -> nums2[b] - nums2[a]);
        int lo = 0, hi = n - 1;
        int[] result = new int[n];
        for (int i : idx2) {
            if (nums1[hi] > nums2[i]) {
                result[i] = nums1[hi--];
            } else {
                result[i] = nums1[lo++];
            }
        }
        return result;
    }
}
