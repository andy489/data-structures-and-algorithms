// https://leetcode.com/problems/find-the-maximum-factor-score-of-array/

/**
 * @param {number[]} nums
 * @return {number}
 */
var maxScore = function(nums) {
    const n = nums.length;

    function gcd(a, b) {
        while (b) { [a, b] = [b, a % b]; }
        return a;
    }
    function lcm(a, b) {
        return a / gcd(a, b) * b;
    }
    function combineLcm(a, b) {
        if (a === 0) { return b; }
        if (b === 0) { return a; }
        return lcm(a, b);
    }

    const prefGcd = new Array(n + 1).fill(0);
    const prefLcm = new Array(n + 1).fill(0);
    const sufGcd = new Array(n + 1).fill(0);
    const sufLcm = new Array(n + 1).fill(0);

    for (let i = 0; i < n; i++) {
        prefGcd[i + 1] = gcd(prefGcd[i], nums[i]);
        prefLcm[i + 1] = combineLcm(prefLcm[i], nums[i]);
    }
    for (let i = n - 1; i >= 0; i--) {
        sufGcd[i] = gcd(sufGcd[i + 1], nums[i]);
        sufLcm[i] = combineLcm(sufLcm[i + 1], nums[i]);
    }

    let ans = prefGcd[n] * prefLcm[n];
    for (let i = 0; i < n; i++) {
        const g = gcd(prefGcd[i], sufGcd[i + 1]);
        const l = combineLcm(prefLcm[i], sufLcm[i + 1]);
        ans = Math.max(ans, g * l);
    }
    return ans;
};
