// https://leetcode.com/problems/minimize-array-sum-using-divisible-replacements/

/**
 * @param {number[]} nums
 * @return {number}
 */
var minimizeSum = function(nums) {
    const valSet = new Set(nums);
    let sum = 0;
    for (const v of nums) {
        let best = v;
        for (let d = 1; d * d <= v; d++) {
            if (v % d === 0) {
                if (valSet.has(d)) {
                    best = Math.min(best, d);
                }
                if (valSet.has(v / d)) {
                    best = Math.min(best, v / d);
                }
            }
        }
        sum += best;
    }
    return sum;
};
