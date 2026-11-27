// https://leetcode.com/problems/minimize-the-maximum-adjacent-element-difference/

// Solution: Binary Search on Answer — O(n log(max)) time, O(1) space
var minDifference = function(nums) {
    const n = nums.length;
    let base = 0;
    for (let i = 0; i < n - 1; i++) {
        if (nums[i] !== -1 && nums[i + 1] !== -1) {
            base = Math.max(base, Math.abs(nums[i] - nums[i + 1]));
        }
    }

    if (nums.every(x => x === -1)) {
        return 0;
    }

    function feasible(d) {
        let xLo = 1, xHi = 2e9;
        const firstReal = nums.findIndex(x => x !== -1);
        if (firstReal > 0) {
            xLo = Math.max(xLo, nums[firstReal] - d);
            xHi = Math.min(xHi, nums[firstReal] + d);
        }

        let i = 0;
        while (i < n) {
            if (nums[i] === -1) {
                i++;
                continue;
            }
            let j = i + 1;
            while (j < n && nums[j] === -1) {
                j++;
            }
            if (j < n) {
                if (j - i > 1) {
                    const a = nums[i], b = nums[j];
                    if (Math.abs(a - b) > 2 * d) {
                        return false;
                    }
                    xLo = Math.max(xLo, Math.max(a, b) - d);
                    xHi = Math.min(xHi, Math.min(a, b) + d);
                }
            } else {
                xLo = Math.max(xLo, nums[i] - d);
                xHi = Math.min(xHi, nums[i] + d);
            }
            i = j;
        }
        return xLo <= xHi;
    }

    let lo = base, hi = 2e9;
    while (lo < hi) {
        const mid = Math.floor((lo + hi) / 2);
        if (feasible(mid)) {
            hi = mid;
        } else {
            lo = mid + 1;
        }
    }
    return lo;
};
