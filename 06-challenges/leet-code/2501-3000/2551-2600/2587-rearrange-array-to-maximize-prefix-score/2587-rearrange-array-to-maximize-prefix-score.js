// https://leetcode.com/problems/rearrange-array-to-maximize-prefix-score/
/**
 * @param {number[]} nums
 * @return {number}
 */
var maxScore = function(nums) {
    nums.sort((a, b) => b - a);
    let score = 0, sum = 0;
    for (const n of nums) {
        sum += n;
        if (sum > 0) {
            score++;
        } else {
            break;
        }
    }
    return score;
};
