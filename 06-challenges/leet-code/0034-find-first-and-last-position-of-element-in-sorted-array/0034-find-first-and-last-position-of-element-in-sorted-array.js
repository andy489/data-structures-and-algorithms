// https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/

// Solution: Unified Binary Search with advance predicate — O(log n) time, O(1) space
// advance(val, target) === true  →  mid is too far left, move lo up
// lower bound: advance when val <  target (stop at first equal)
// upper bound: advance when val <= target (stop after last equal)
var bound = function(nums, target, advance) {
    let lo = 0, hi = nums.length - 1, res = -1;
    while (lo <= hi) {
        const mid = lo + Math.floor((hi - lo) / 2);
        if (nums[mid] === target) {
            res = mid;
        }
        if (advance(nums[mid], target)) {
            lo = mid + 1;
        } else {
            hi = mid - 1;
        }
    }
    return res;
};

var searchRange = function(nums, target) {
    return [
        bound(nums, target, (val, t) => val < t),
        bound(nums, target, (val, t) => val <= t),
    ];
};

// Solution 2: Lower Bound with target ± 0.5 — O(log n) time, O(1) space
var lowerBound = function(nums, x) {
    let lo = 0, hi = nums.length - 1;
    while (lo <= hi) {
        const mid = lo + Math.floor((hi - lo) / 2);
        if (nums[mid] < x) {
            lo = mid + 1;
        } else {
            hi = mid - 1;
        }
    }
    return lo;
};

var searchRange2 = function(nums, target) {
    const first = lowerBound(nums, target - 0.5);
    const last  = lowerBound(nums, target + 0.5) - 1;
    if (first > last) {
        return [-1, -1];
    }
    return [first, last];
};
