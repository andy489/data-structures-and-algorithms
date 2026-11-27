// https://leetcode.com/problems/sum-of-even-numbers-after-queries/

var sumEvenAfterQueries = function(nums, queries) {
    let evenSum = nums.reduce((s, x) => s + (x % 2 === 0 ? x : 0), 0);
    return queries.map(([val, idx]) => {
        if (nums[idx] % 2 === 0) evenSum -= nums[idx];
        nums[idx] += val;
        if (nums[idx] % 2 === 0) evenSum += nums[idx];
        return evenSum;
    });
};
