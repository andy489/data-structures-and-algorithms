// https://leetcode.com/problems/the-number-of-beautiful-subsets/
/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var beautifulSubsets = function(nums, k) {
    nums.sort((a, b) => a - b);
    const freq = new Map();
    let count = 0;

    function backtrack(idx) {
        for (let i = idx; i < nums.length; i++) {
            const num = nums[i];
            if ((freq.get(num - k) || 0) === 0) {
                freq.set(num, (freq.get(num) || 0) + 1);
                count++;
                backtrack(i + 1);
                freq.set(num, freq.get(num) - 1);
                if (freq.get(num) === 0) {
                    freq.delete(num);
                }
            }
        }
    }

    backtrack(0);
    return count;
};
