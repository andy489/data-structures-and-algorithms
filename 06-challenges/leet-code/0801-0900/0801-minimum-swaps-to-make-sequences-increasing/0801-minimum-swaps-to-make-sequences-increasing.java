// https://leetcode.com/problems/minimum-swaps-to-make-sequences-increasing/

// Solution: Dynamic Programming — O(n) time, O(1) space
class Solution {
    public int minSwap(int[] nums1, int[] nums2) {
        int keep = 0, swap = 1;
        for (int i = 1; i < nums1.length; i++) {
            int newKeep = Integer.MAX_VALUE, newSwap = Integer.MAX_VALUE;
            if (nums1[i] > nums1[i - 1] && nums2[i] > nums2[i - 1]) {
                newKeep = Math.min(newKeep, keep);
                newSwap = Math.min(newSwap, swap + 1);
            }
            if (nums1[i] > nums2[i - 1] && nums2[i] > nums1[i - 1]) {
                newKeep = Math.min(newKeep, swap);
                newSwap = Math.min(newSwap, keep + 1);
            }
            keep = newKeep;
            swap = newSwap;
        }
        return Math.min(keep, swap);
    }
}
