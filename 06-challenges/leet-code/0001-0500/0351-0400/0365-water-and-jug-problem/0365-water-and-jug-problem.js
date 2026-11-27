// https://leetcode.com/problems/water-and-jug-problem/

// Solution: Bézout's Identity (GCD) — O(log(min(x,y))) time, O(1) space
var canMeasureWater = function(x, y, target) {
    if (target > x + y) return false;
    const gcd = (a, b) => b === 0 ? a : gcd(b, a % b);
    return target % gcd(x, y) === 0;
};
