// https://leetcode.com/problems/maximum-subarray-with-equal-products/

var maxLength = function(nums) {
    const gcd = (a, b) => b === 0 ? a : gcd(b, a % b);
    const lcm = (a, b) => a / gcd(a, b) * b;

    const n = nums.length;
    let best = 1;
    for (let i = 0; i < n; i++) {
        let prod = nums[i], g = nums[i], l = nums[i];
        for (let j = i + 1; j < n; j++) {
            prod *= nums[j];
            g = gcd(g, nums[j]);
            l = lcm(l, nums[j]);
            if (prod === l * g) {
                best = Math.max(best, j - i + 1);
            } else if (prod > l * g) {
                break;
            }
        }
    }
    return best;
};
