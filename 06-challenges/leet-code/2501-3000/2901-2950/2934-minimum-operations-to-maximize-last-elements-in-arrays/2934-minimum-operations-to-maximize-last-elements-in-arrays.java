// https://leetcode.com/problems/minimum-operations-to-maximize-last-elements-in-arrays/

// Solution: Try Both Last-Element Configurations — O(n) time, O(1) space
class Solution {
    public int minOperations(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int a = nums1[n - 1];
        int b = nums2[n - 1];
        int op1 = count(nums1, nums2, a, b, n);
        int op2 = count(nums1, nums2, b, a, n);
        if (op1 == -1 && op2 == -1) {
            return -1;
        }
        if (op1 == -1) {
            return op2 + 1;
        }
        if (op2 == -1) {
            return op1;
        }
        return Math.min(op1, op2 + 1);
    }

    private int count(int[] nums1, int[] nums2, int a, int b, int n) {
        int swaps = 0;
        for (int i = 0; i < n - 1; i++) {
            if (nums1[i] <= a && nums2[i] <= b) {
                // no swap needed
            } else if (nums2[i] <= a && nums1[i] <= b) {
                swaps++;
            } else {
                return -1;
            }
        }
        return swaps;
    }
}
