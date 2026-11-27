// https://leetcode.com/problems/count-good-subarrays/

/**
 * @param {number[]} nums
 * @return {number}
 */
var countGoodSubarrays = function(nums) {
    const n = nums.length;
    let ans = 0;
    const freq = new Map();
    let windowOr = 0;
    let left = 0;
    let curMax = 0;

    for (let right = 0; right < n; right++) {
        freq.set(nums[right], (freq.get(nums[right]) ?? 0) + 1);
        windowOr |= nums[right];
        if (nums[right] > curMax) { curMax = nums[right]; }

        while (windowOr !== curMax) {
            const rem = nums[left++];
            freq.set(rem, freq.get(rem) - 1);
            if (freq.get(rem) === 0) { freq.delete(rem); }
            // recompute OR
            windowOr = 0;
            for (let i = left; i <= right; i++) { windowOr |= nums[i]; }
            // recompute max
            curMax = 0;
            for (const k of freq.keys()) { if (k > curMax) { curMax = k; } }
        }
        ans += right - left + 1;
    }
    return ans;
};
