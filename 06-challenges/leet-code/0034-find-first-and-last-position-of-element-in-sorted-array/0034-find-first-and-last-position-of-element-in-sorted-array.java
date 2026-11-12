// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

// Solution: Unified Binary Search with advance predicate — O(log n) time, O(1) space
class Solution {
    // advance(val, target) == true  →  mid is too far left, move lo up
    // lower bound: advance when val <  target (stop at first equal)
    // upper bound: advance when val <= target (stop after last equal)
    private int bound(int[] nums, int target, java.util.function.BiPredicate<Integer, Integer> advance) {
        int lo = 0, hi = nums.length - 1, res = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                res = mid;
            }
            if (advance.test(nums[mid], target)) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return res;
    }

    public int[] searchRange(int[] nums, int target) {
        return new int[]{
            bound(nums, target, (val, t) -> val < t),
            bound(nums, target, (val, t) -> val <= t)
        };
    }
}

// Solution2: Lower Bound with target ± 0.5 — O(log n) time, O(1) space
class Solution2 {
    private int lowerBound(int[] nums, double x) {
        int lo = 0, hi = nums.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] < x) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }

    public int[] searchRange(int[] nums, int target) {
        int first = lowerBound(nums, target - 0.5);
        int last  = lowerBound(nums, target + 0.5) - 1;
        if (first > last) {
            return new int[]{-1, -1};
        }
        return new int[]{first, last};
    }
}
