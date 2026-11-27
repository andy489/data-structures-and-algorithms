// https://leetcode.com/problems/divide-array-into-equal-pairs/
var divideArray = function(nums) {
    const freq = new Map();
    for (const num of nums) {
        freq.set(num, (freq.get(num) || 0) + 1);
    }
    for (const count of freq.values()) {
        if (count % 2 !== 0) {
            return false;
        }
    }
    return true;
};
