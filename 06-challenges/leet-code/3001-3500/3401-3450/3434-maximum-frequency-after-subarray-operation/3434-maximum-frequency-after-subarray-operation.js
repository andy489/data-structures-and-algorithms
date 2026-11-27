// https://leetcode.com/problems/maximum-frequency-after-subarray-operation/
/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number}
 */
var maxFrequency = function(nums, k) {
    const countK = nums.filter(x => x === k).length;
    let best = countK;

    for (let v = 1; v <= 50; v++) {
        if (v === k) {
            continue;
        }
        let cur = 0;
        let maxGain = 0;
        for (const num of nums) {
            if (num === v) {
                cur++;
            } else if (num === k) {
                cur--;
            }
            if (cur < 0) {
                cur = 0;
            }
            if (cur > maxGain) {
                maxGain = cur;
            }
        }
        const total = countK + maxGain;
        if (total > best) {
            best = total;
        }
    }

    return best;
};
