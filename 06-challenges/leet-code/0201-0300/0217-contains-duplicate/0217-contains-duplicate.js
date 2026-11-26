// https://leetcode.com/problems/contains-duplicate/

// Solution: HashSet — O(n) time, O(n) space
var containsDuplicate = function(nums) {
    return new Set(nums).size !== nums.length;
};
