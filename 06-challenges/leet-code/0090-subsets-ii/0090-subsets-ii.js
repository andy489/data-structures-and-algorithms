// https://leetcode.com/problems/subsets-ii/

var subsetsWithDup = function(nums) {
    const result = [];
    nums.sort((a, b) => a - b);

    function backtrack(start, current) {
        result.push([...current]);
        for (let i = start; i < nums.length; i++) {
            if (i > start && nums[i] === nums[i - 1]) {
                continue;
            }
            current.push(nums[i]);
            backtrack(i + 1, current);
            current.pop();
        }
    }

    backtrack(0, []);
    return result;
};

// Solution 2: Iterative Insertion — O(n·2^n) time, O(1) space
var subsetsWithDup2 = function(nums) {
    const result = [[]];
    nums.sort((a, b) => a - b);
    let prevSize = 0;
    for (let i = 0; i < nums.length; i++) {
        const start = (i > 0 && nums[i] === nums[i - 1]) ? prevSize : 0;
        prevSize = result.length;
        for (let j = start; j < prevSize; j++) {
            result.push([...result[j], nums[i]]);
        }
    }
    return result;
};
