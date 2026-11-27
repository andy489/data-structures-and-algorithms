// https://leetcode.com/problems/sum-of-sortable-integers/

/**
 * @param {number[]} nums
 * @return {number}
 */
var sumOfSortableIntegers = function(nums) {
    const n = nums.length;
    const sorted = [...nums].sort((a, b) => a - b);
    let ans = 0;

    function isCyclicRotation(start, end) {
        const k = end - start;
        const first = sorted[start];
        for (let offset = 0; offset < k; offset++) {
            if (nums[start + offset] === first) {
                let ok = true;
                for (let j = 0; j < k; j++) {
                    if (nums[start + (offset + j) % k] !== sorted[start + j]) {
                        ok = false;
                        break;
                    }
                }
                if (ok) { return true; }
            }
        }
        return false;
    }

    for (let k = 1; k <= n; k++) {
        if (n % k !== 0) { continue; }
        let sortable = true;
        for (let i = 0; i < n; i += k) {
            if (!isCyclicRotation(i, i + k)) {
                sortable = false;
                break;
            }
        }
        if (sortable) { ans += k; }
    }
    return ans;
};
