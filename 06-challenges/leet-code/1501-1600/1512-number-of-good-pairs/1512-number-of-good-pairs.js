// https://leetcode.com/problems/number-of-good-pairs/

var numIdenticalPairs = function(nums) {
    const count = {};
    let result = 0;
    for (const num of nums) {
        result += (count[num] || 0);
        count[num] = (count[num] || 0) + 1;
    }
    return result;
};
