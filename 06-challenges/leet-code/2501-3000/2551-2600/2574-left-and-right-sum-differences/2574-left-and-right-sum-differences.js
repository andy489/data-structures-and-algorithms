// https://leetcode.com/problems/left-and-right-sum-differences/

/**
 * @param {number[]} nums
 * @return {number[]}
 */
var leftRightDifference = function(nums) {
    const total = nums.reduce((s, x) => s + x, 0);
    const answer = [];
    let left = 0;
    for (const x of nums) {
        const right = total - left - x;
        answer.push(Math.abs(left - right));
        left += x;
    }
    return answer;
};
