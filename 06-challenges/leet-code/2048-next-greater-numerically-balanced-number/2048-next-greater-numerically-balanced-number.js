// https://leetcode.com/problems/next-greater-numerically-balanced-number/

// Solution: Brute Force Check — O(range * L) time, O(1) space
var nextBeautifulNumber = function(n) {
    const isBalanced = (x) => {
        const freq = {};
        for (const c of String(x)) freq[c] = (freq[c] || 0) + 1;
        return Object.entries(freq).every(([d, cnt]) => parseInt(d) === cnt);
    };
    for (let c = n + 1; ; c++) { if (isBalanced(c)) return c; }
};
