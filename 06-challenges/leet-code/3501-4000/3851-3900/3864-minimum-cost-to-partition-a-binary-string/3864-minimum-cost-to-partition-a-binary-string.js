// https://leetcode.com/problems/minimum-cost-to-partition-a-binary-string/

/**
 * @param {string} s
 * @param {number} encCost
 * @param {number} flatCost
 * @return {number}
 */
var minimumCost = function(s, encCost, flatCost) {
    const n = s.length;
    const prefix = new Array(n + 1).fill(0);
    for (let i = 0; i < n; i++) {
        prefix[i + 1] = prefix[i] + (s[i] === '1' ? 1 : 0);
    }
    const memo = new Map();

    function solve(l, r) {
        const len = r - l + 1;
        const ones = prefix[r + 1] - prefix[l];
        const cost = ones === 0 ? flatCost : len * ones * encCost;
        if (len % 2 !== 0) return cost;
        const key = l * 100001 + r;
        if (memo.has(key)) return memo.get(key);
        const mid = (l + r) >> 1;
        const split = solve(l, mid) + solve(mid + 1, r);
        const result = Math.min(cost, split);
        memo.set(key, result);
        return result;
    }

    return solve(0, n - 1);
};
