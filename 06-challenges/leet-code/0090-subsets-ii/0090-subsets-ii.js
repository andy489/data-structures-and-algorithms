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
