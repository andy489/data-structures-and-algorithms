// https://leetcode.com/problems/subsets/

// Solution: Backtracking
var subsets = function(nums) {
    const result = [];
    function backtrack(start, current) {
        result.push([...current]);
        for (let i = start; i < nums.length; i++) {
            current.push(nums[i]);
            backtrack(i + 1, current);
            current.pop();
        }
    }
    backtrack(0, []);
    return result;
};

// Solution 2: Bit Manipulation
var subsets2 = function(nums) {
    const n = nums.length, result = [];
    for (let mask = 0; mask < (1 << n); mask++) {
        const subset = [];
        for (let j = 0; j < n; j++) {
            if (mask & (1 << j)) subset.push(nums[j]);
        }
        result.push(subset);
    }
    return result;
};
