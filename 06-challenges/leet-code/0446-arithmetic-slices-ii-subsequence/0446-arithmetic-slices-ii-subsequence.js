// https://leetcode.com/problems/arithmetic-slices-ii-subsequence/

var numberOfArithmeticSlices = function(nums) {
    const n = nums.length;
    const dp = Array.from({length: n}, () => new Map());
    let answer = 0;
    for (let i = 1; i < n; i++) {
        for (let j = 0; j < i; j++) {
            const diff = nums[i] - nums[j];
            const countAtJ = dp[j].get(diff) || 0;
            answer += countAtJ;
            dp[i].set(diff, (dp[i].get(diff) || 0) + countAtJ + 1);
        }
    }
    return answer;
};
