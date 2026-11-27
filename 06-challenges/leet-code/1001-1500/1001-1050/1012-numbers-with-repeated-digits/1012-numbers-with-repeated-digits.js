// https://leetcode.com/problems/numbers-with-repeated-digits/

var numDupDigitsAtMostN = function(n) {
    const perm = (m, k) => { let p = 1; for (let i = 0; i < k; i++) p *= (m - i); return p; };
    const digits = [...String(n + 1)].map(Number);
    const len = digits.length;
    let result = 0;
    let p = 9;
    for (let i = 1; i < len; i++) { result += p; p *= (10 - i); }
    const used = new Set();
    for (let i = 0; i < len; i++) {
        const d = digits[i];
        const start = i === 0 ? 1 : 0;
        for (let x = start; x < d; x++) {
            if (!used.has(x)) result += perm(10 - i - 1, len - i - 1);
        }
        if (used.has(d)) break;
        used.add(d);
        if (i === len - 1) result++;
    }
    return n - result;
};
