// https://leetcode.com/problems/sum-of-mutated-array-closest-to-target/

// Solution: Binary Search — O(n log n) time, O(1) space
// Solution: Binary Search — O(n log n) time, O(1) space
class Solution {
    public int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int n = arr.length, lo = 0, hi = arr[n-1], best = 0, bestDiff = Integer.MAX_VALUE;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int sum = computeSum(arr, mid);
            int diff = Math.abs(sum - target);
            if (diff < bestDiff || (diff == bestDiff && mid < best)) { bestDiff = diff; best = mid; }
            if (sum < target) lo = mid + 1;
            else hi = mid - 1;
        }
        return best;
    }
    private int computeSum(int[] arr, int val) {
        int sum = 0;
        for (int x : arr) sum += Math.min(x, val);
        return sum;
    }
}
