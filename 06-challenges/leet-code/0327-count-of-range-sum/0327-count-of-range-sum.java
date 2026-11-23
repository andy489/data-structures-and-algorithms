// https://leetcode.com/problems/count-of-range-sum/

// Solution: Merge Sort on Prefix Sums — O(n log n) time, O(n) space
class Solution {
    private int lower, upper, count;

    public int countRangeSum(int[] nums, int lower, int upper) {
        this.lower = lower;
        this.upper = upper;
        this.count = 0;
        int n = nums.length;
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }
        mergeSort(prefix, 0, prefix.length - 1);
        return count;
    }

    private void mergeSort(long[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        int lo = mid + 1, hi = mid + 1;
        for (int i = left; i <= mid; i++) {
            while (lo <= right && arr[lo] - arr[i] < lower) {
                lo++;
            }
            while (hi <= right && arr[hi] - arr[i] <= upper) {
                hi++;
            }
            count += hi - lo;
        }
        long[] temp = new long[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        while (i <= mid && j <= right) {
            temp[k++] = arr[i] <= arr[j] ? arr[i++] : arr[j++];
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        System.arraycopy(temp, 0, arr, left, temp.length);
    }
}
