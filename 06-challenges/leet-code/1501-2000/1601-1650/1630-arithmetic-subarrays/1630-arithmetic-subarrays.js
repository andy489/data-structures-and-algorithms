// https://leetcode.com/problems/arithmetic-subarrays/

var checkArithmeticSubarrays = function(nums, l, r) {
    function isArithmetic(sub) {
        sub = [...sub].sort((a, b) => a - b);
        const diff = sub[1] - sub[0];
        for (let i = 2; i < sub.length; i++) {
            if (sub[i] - sub[i - 1] !== diff) return false;
        }
        return true;
    }
    return l.map((li, i) => isArithmetic(nums.slice(li, r[i] + 1)));
};
