// https://leetcode.com/problems/kth-missing-positive-number/

// Solution: Binary Search — O(log n) time, O(1) space
class Solution {
    public int findKthPositive(int[] arr, int k) {
        int lo = 0, hi = arr.length;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (arr[mid] - (mid + 1) >= k) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo + k;
    }
}
