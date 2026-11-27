// https://leetcode.com/problems/sum-of-gcd-of-formed-pairs/

/**
 * @param {number[]} nums
 * @return {number}
 */
var sumOfGCDPairs = function(nums) {
    function gcd(a, b) {
        while (b) { [a, b] = [b, a % b]; }
        return a;
    }
    const n = nums.length;
    const pg = [];
    let maxSoFar = nums[0];
    for (const v of nums) {
        maxSoFar = Math.max(maxSoFar, v);
        pg.push(gcd(v, maxSoFar));
    }
    pg.sort((a, b) => a - b);
    let total = 0;
    let l = 0, r = n - 1;
    while (l < r) {
        total += gcd(pg[l], pg[r]);
        l++;
        r--;
    }
    return total;
};
