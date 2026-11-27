// https://leetcode.com/problems/number-of-pairs-of-strings-with-concatenation-equal-to-target/

// Solution: Prefix Matching — O(n^2 * L) time, O(1) space
var numOfPairs = function(nums, target) {
    let count = 0;
    for (let i = 0; i < nums.length; i++) {
        for (let j = 0; j < nums.length; j++) {
            if (i !== j && nums[i] + nums[j] === target) count++;
        }
    }
    return count;
};
