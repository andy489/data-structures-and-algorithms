// https://leetcode.com/problems/increasing-triplet-subsequence/

// Solution: Two Variables — O(n) time, O(1) space
var increasingTriplet = function(nums) {
    let first = Infinity, second = Infinity;
    for (const num of nums) {
        if (num <= first) {
            first = num;
        } else if (num <= second) {
            second = num;
        } else {
            return true;
        }
    }
    return false;
};
