// https://leetcode.com/problems/find-minimum-cost-to-remove-array-elements/

var minCost = function(nums) {
    const n = nums.length;
    const memo = new Map();

    function dp(idx, carry) {
        if (idx === n && carry === 0) return 0;
        if (idx === n) return carry;
        const key = idx * 1000001 + carry;
        if (memo.has(key)) return memo.get(key);
        let result;
        if (carry === 0) {
            if (idx + 1 >= n) {
                result = nums[idx];
            } else {
                result = Math.max(nums[idx], nums[idx + 1]) + dp(idx + 2, 0);
            }
        } else {
            if (idx + 1 >= n) {
                result = Math.max(carry, nums[idx]);
            } else {
                const [a, b, c] = [carry, nums[idx], nums[idx + 1]];
                const opt1 = Math.max(a, b) + dp(idx + 2, c);
                const opt2 = Math.max(a, c) + dp(idx + 2, b);
                const opt3 = Math.max(b, c) + dp(idx + 2, a);
                result = Math.min(opt1, opt2, opt3);
            }
        }
        memo.set(key, result);
        return result;
    }

    return dp(0, 0);
};
