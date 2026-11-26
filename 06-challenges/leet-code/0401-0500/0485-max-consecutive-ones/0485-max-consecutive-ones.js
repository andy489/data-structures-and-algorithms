// https://leetcode.com/problems/max-consecutive-ones/

var findMaxConsecutiveOnes = function(nums) {
    let maxCount = 0;
    let current = 0;
    for (const num of nums) {
        if (num === 1) {
            current++;
            if (current > maxCount) maxCount = current;
        } else {
            current = 0;
        }
    }
    return maxCount;
};
