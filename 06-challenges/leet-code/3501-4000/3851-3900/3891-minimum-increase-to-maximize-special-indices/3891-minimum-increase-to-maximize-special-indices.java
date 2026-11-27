// https://leetcode.com/problems/minimum-increase-to-maximize-special-indices/
class Solution {
    public long minimumIncreaseToMaximizeSpecialIndices(int[] nums) {
        int n = nums.length;
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nums[i];
        }

        long ops = 0;
        int i = 1;
        while (i < n - 1) {
            long needed = Math.max(arr[i - 1], arr[i + 1]) + 1 - arr[i];
            if (needed > 0) {
                ops += needed;
                arr[i] += needed;
            }
            // If we just made i special, skip i+1
            if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                i += 2;
            } else {
                i++;
            }
        }
        return ops;
    }
}
