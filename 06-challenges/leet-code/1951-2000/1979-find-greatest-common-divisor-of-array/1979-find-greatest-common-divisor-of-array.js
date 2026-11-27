// https://leetcode.com/problems/find-greatest-common-divisor-of-array/

// Solution: Min/Max + GCD — O(n) time, O(1) space
var findGCD = function(nums) {
    const gcd = (a, b) => b === 0 ? a : gcd(b, a % b);
    return gcd(Math.min(...nums), Math.max(...nums));
};
