// https://leetcode.com/problems/kth-largest-element-in-an-array/

// Solution: Quickselect — O(n) average time, O(1) space
var findKthLargest = function(nums, k) {
    function partition(lo, hi) {
        const pivotIdx = lo + Math.floor(Math.random() * (hi - lo + 1));
        [nums[pivotIdx], nums[hi]] = [nums[hi], nums[pivotIdx]];
        const pivot = nums[hi];
        let i = lo;
        for (let j = lo; j < hi; j++) {
            if (nums[j] >= pivot) {
                [nums[i], nums[j]] = [nums[j], nums[i]];
                i++;
            }
        }
        [nums[i], nums[hi]] = [nums[hi], nums[i]];
        return i;
    }

    let lo = 0, hi = nums.length - 1;
    while (lo <= hi) {
        const pos = partition(lo, hi);
        if (pos === k - 1) {
            return nums[pos];
        } else if (pos < k - 1) {
            lo = pos + 1;
        } else {
            hi = pos - 1;
        }
    }
    return -1;
};
