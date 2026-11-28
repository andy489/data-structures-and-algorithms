// https://leetcode.com/problems/maximum-strong-pair-xor-i/

var maximumStrongPairXor = function(nums) {
    let ans = 0;
    for (const x of nums) {
        for (const y of nums) {
            if (Math.abs(x - y) <= Math.min(x, y)) {
                ans = Math.max(ans, x ^ y);
            }
        }
    }
    return ans;
};
