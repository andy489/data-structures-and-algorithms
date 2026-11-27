// https://leetcode.com/problems/find-x-sum-of-all-k-long-subarrays-i/

/**
 * @param {number[]} nums
 * @param {number} k
 * @param {number} x
 * @return {number[]}
 */
var findXSum = function (nums, k, x) {
    const n = nums.length;
    const answer = [];
    for (let i = 0; i <= n - k; i++) {
        const freq = new Map();
        for (let j = i; j < i + k; j++) {
            freq.set(nums[j], (freq.get(nums[j]) || 0) + 1);
        }
        const entries = [...freq.entries()].sort((a, b) => {
            if (a[1] !== b[1]) {
                return b[1] - a[1];
            }
            return b[0] - a[0];
        });
        let sum = 0;
        for (let t = 0; t < Math.min(x, entries.length); t++) {
            sum += entries[t][0] * entries[t][1];
        }
        answer.push(sum);
    }
    return answer;
};
