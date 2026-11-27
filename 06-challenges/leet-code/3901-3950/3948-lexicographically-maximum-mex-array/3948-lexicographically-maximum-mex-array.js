// https://leetcode.com/problems/lexicographically-maximum-mex-array/
/**
 * @param {number[]} nums
 * @return {number[]}
 */
var findLexMaxMEXArray = function(nums) {
    const n = nums.length;
    const result = [];
    let start = 0;
    while (start < n) {
        const freq = new Array(n + 2).fill(0);
        let mex = 0;
        let bestMex = 0;
        let bestEnd = start;
        for (let end = start; end < n; end++) {
            const v = nums[end];
            if (v <= n) {
                freq[v]++;
            }
            while (freq[mex] > 0) {
                mex++;
            }
            if (mex >= bestMex) {
                bestMex = mex;
                bestEnd = end;
            }
        }
        result.push(bestMex);
        start = bestEnd + 1;
    }
    return result;
};
