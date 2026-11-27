// https://leetcode.com/problems/minimum-limit-of-balls-in-a-bag/

// Solution: Binary Search on Answer — O(n log(max)) time, O(1) space
class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int lo = 1, hi = 0;
        for (int n : nums) {
            hi = Math.max(hi, n);
        }
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (canAchieve(nums, maxOperations, mid)) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    private boolean canAchieve(int[] nums, int maxOps, int penalty) {
        long ops = 0;
        for (int n : nums) {
            ops += (n - 1) / penalty;
        }
        return ops <= maxOps;
    }
}
