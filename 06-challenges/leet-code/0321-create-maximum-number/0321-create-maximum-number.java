// https://leetcode.com/problems/create-maximum-number/

// Solution: Monotonic Stack + Merge — O(k*(m+n)) time, O(m+n) space
class Solution {
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int m = nums1.length, n = nums2.length;
        int[] result = new int[k];
        for (int i = Math.max(0, k - n); i <= Math.min(k, m); i++) {
            int[] sub1 = maxSubsequence(nums1, i);
            int[] sub2 = maxSubsequence(nums2, k - i);
            int[] candidate = merge(sub1, sub2);
            if (compare(candidate, 0, result, 0) > 0) {
                result = candidate;
            }
        }
        return result;
    }

    private int[] maxSubsequence(int[] nums, int k) {
        int[] stack = new int[k];
        int top = 0, drop = nums.length - k;
        for (int num : nums) {
            while (top > 0 && drop > 0 && stack[top - 1] < num) {
                top--;
                drop--;
            }
            if (top < k) {
                stack[top++] = num;
            } else {
                drop--;
            }
        }
        return stack;
    }

    private int[] merge(int[] a, int[] b) {
        int[] result = new int[a.length + b.length];
        int i = 0, j = 0, k = 0;
        while (i < a.length || j < b.length) {
            result[k++] = compare(a, i, b, j) >= 0 ? a[i++] : b[j++];
        }
        return result;
    }

    private int compare(int[] a, int i, int[] b, int j) {
        while (i < a.length && j < b.length) {
            if (a[i] != b[j]) {
                return a[i] - b[j];
            }
            i++;
            j++;
        }
        return (a.length - i) - (b.length - j);
    }
}
