// https://leetcode.com/problems/maximum-number-of-operations-with-the-same-score-ii/

var maxOperations = function(nums) {
    const n = nums.length;
    function solve(target) {
        const memo = Array.from({length: n}, () => new Array(n).fill(-1));
        function dp(l, r) {
            if (r - l < 1) return 0;
            if (memo[l][r] !== -1) return memo[l][r];
            let res = 0;
            if (nums[l]+nums[l+1] === target) res = Math.max(res, 1+dp(l+2,r));
            if (nums[r-1]+nums[r] === target) res = Math.max(res, 1+dp(l,r-2));
            if (nums[l]+nums[r] === target) res = Math.max(res, 1+dp(l+1,r-1));
            return memo[l][r] = res;
        }
        return dp(0, n-1);
    }
    return Math.max(solve(nums[0]+nums[1]), solve(nums[n-1]+nums[n-2]), solve(nums[0]+nums[n-1]));
};
