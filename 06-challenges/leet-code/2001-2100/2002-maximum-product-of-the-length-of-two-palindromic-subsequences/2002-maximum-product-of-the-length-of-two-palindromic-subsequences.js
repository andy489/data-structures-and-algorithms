// https://leetcode.com/problems/maximum-product-of-the-length-of-two-palindromic-subsequences/

// Solution: Bitmask Enumeration — O(3^n) time, O(2^n) space
var maxProduct = function(s) {
    const n = s.length, full = 1 << n;
    const palin = new Int32Array(full);
    const isPalin = (mask) => {
        const chars = [];
        for (let i = 0; i < n; i++) { if (mask >> i & 1) chars.push(s[i]); }
        for (let l = 0, r = chars.length - 1; l < r; l++, r--) {
            if (chars[l] !== chars[r]) return 0;
        }
        return chars.length;
    };
    for (let mask = 1; mask < full; mask++) { palin[mask] = isPalin(mask); }
    let res = 0;
    for (let mask = 1; mask < full; mask++) {
        if (!palin[mask]) continue;
        const comp = (full - 1) ^ mask;
        for (let sub = comp; sub > 0; sub = (sub - 1) & comp) {
            if (palin[sub]) res = Math.max(res, palin[mask] * palin[sub]);
        }
    }
    return res;
};
