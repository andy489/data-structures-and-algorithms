// https://leetcode.com/problems/sort-an-array/

// Solution: Merge Sort — O(n log n) time, O(n) space
class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1, new int[nums.length]);
        return nums;
    }

    private void mergeSort(int[] nums, int lo, int hi, int[] buf) {
        if (lo >= hi) {
            return;
        }
        int mid = (lo + hi) / 2;
        mergeSort(nums, lo, mid, buf);
        mergeSort(nums, mid + 1, hi, buf);
        merge(nums, lo, mid, hi, buf);
    }

    private void merge(int[] nums, int lo, int mid, int hi, int[] buf) {
        for (int i = lo; i <= hi; i++) {
            buf[i] = nums[i];
        }
        int l = lo, r = mid + 1, k = lo;
        while (l <= mid && r <= hi) {
            nums[k++] = buf[l] <= buf[r] ? buf[l++] : buf[r++];
        }
        while (l <= mid) {
            nums[k++] = buf[l++];
        }
    }
}
