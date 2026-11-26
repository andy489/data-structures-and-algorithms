// https://leetcode.com/problems/find-missing-observations/

// Solution: Math Distribution — O(m+n) time, O(n) space
var missingRolls = function(rolls, mean, n) {
    const m = rolls.length;
    const needed = (m + n) * mean - rolls.reduce((a, b) => a + b, 0);
    if (needed < n || needed > 6 * n) return [];
    const base = Math.floor(needed / n), rem = needed % n;
    return Array.from({length: n}, (_, i) => base + (i < rem ? 1 : 0));
};
