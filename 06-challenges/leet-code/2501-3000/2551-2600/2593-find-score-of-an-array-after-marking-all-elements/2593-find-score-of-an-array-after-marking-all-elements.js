// https://leetcode.com/problems/find-score-of-an-array-after-marking-all-elements/
/**
 * @param {number[]} nums
 * @return {number}
 */
var findScore = function(nums) {
    const n = nums.length;
    const indexed = nums.map((v, i) => [v, i]);
    indexed.sort((a, b) => a[0] !== b[0] ? a[0] - b[0] : a[1] - b[1]);
    const marked = new Array(n).fill(false);
    let score = 0;
    for (const [val, idx] of indexed) {
        if (!marked[idx]) {
            score += val;
            marked[idx] = true;
            if (idx > 0) {
                marked[idx - 1] = true;
            }
            if (idx < n - 1) {
                marked[idx + 1] = true;
            }
        }
    }
    return score;
};
