// https://leetcode.com/problems/minimum-impossible-or/

// Solution: Check Powers of 2 — O(n) time, O(n) space
var minImpossibleOR = function(nums) {
    const numsSet = new Set(nums);
    let power = 1;
    while (numsSet.has(power)) {
        power <<= 1;
    }
    return power;
};
