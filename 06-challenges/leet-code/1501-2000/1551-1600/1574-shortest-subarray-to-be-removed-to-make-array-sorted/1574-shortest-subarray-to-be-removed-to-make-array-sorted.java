// https://leetcode.com/problems/shortest-subarray-to-be-removed-to-make-array-sorted/

// Solution: Two Pointers — O(n) time, O(1) space
class Solution {
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        int r = n - 1;
        while (r > 0 && arr[r] >= arr[r - 1]) {
            r--;
        }
        int result = r; // remove arr[0..r-1]
        int l = 0;
        while (l < r) {
            while (r < n && arr[r] < arr[l]) {
                r++;
            }
            result = Math.min(result, r - l - 1);
            if (arr[l + 1] >= arr[l]) {
                l++;
            } else {
                break;
            }
        }
        return result;
    }
}
