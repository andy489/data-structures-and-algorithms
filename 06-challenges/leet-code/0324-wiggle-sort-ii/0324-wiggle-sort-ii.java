// https://leetcode.com/problems/wiggle-sort-ii/

// Solution: Sort + Interleave — O(n log n) time, O(n) space
class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        int[] sorted = nums.clone();
        java.util.Arrays.sort(sorted);
        int mid = (n - 1) / 2;
        int large = n - 1;
        for (int i = 0; i < n; i++) {
            nums[i] = (i % 2 == 0) ? sorted[mid--] : sorted[large--];
        }
    }
}
