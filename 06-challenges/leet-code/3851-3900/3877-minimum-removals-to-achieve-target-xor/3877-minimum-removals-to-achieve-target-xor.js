// https://leetcode.com/problems/minimum-removals-to-achieve-target-xor/

/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var minRemovals = function(nums, target) {
    const n = nums.length;
    const half = Math.floor(n / 2);
    const leftMap = new Map();
    for (let mask = 0; mask < (1 << half); mask++) {
        let xor = 0, cnt = 0;
        for (let i = 0; i < half; i++) {
            if ((mask >> i) & 1) { xor ^= nums[i]; cnt++; }
        }
        leftMap.set(xor, Math.max(leftMap.get(xor) ?? -1, cnt));
    }

    let maxKept = -1;
    const rightLen = n - half;
    for (let mask = 0; mask < (1 << rightLen); mask++) {
        let xor = 0, cnt = 0;
        for (let i = 0; i < rightLen; i++) {
            if ((mask >> i) & 1) { xor ^= nums[half + i]; cnt++; }
        }
        const need = xor ^ target;
        if (leftMap.has(need)) {
            maxKept = Math.max(maxKept, cnt + leftMap.get(need));
        }
    }

    return maxKept === -1 ? -1 : n - maxKept;
};
