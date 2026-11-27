// https://leetcode.com/problems/non-decreasing-subsequences/

var findSubsequences = function(nums) {
    const results = [];

    const backtrack = (start, current) => {
        if (current.length >= 2) results.push([...current]);
        const usedAtLevel = new Set();
        for (let i = start; i < nums.length; i++) {
            if (usedAtLevel.has(nums[i])) continue;
            if (current.length === 0 || nums[i] >= current[current.length - 1]) {
                usedAtLevel.add(nums[i]);
                current.push(nums[i]);
                backtrack(i + 1, current);
                current.pop();
            }
        }
    };

    backtrack(0, []);
    return results;
};
