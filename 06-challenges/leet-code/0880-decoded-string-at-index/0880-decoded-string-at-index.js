// https://leetcode.com/problems/decoded-string-at-index/

var decodeAtIndex = function(s, k) {
    let size = 0n;
    for (const c of s) {
        size = /\d/.test(c) ? size * BigInt(c) : size + 1n;
    }
    k = BigInt(k);
    for (let i = s.length - 1; i >= 0; i--) {
        const c = s[i];
        k %= size;
        if (k === 0n && /[a-z]/.test(c)) return c;
        size = /\d/.test(c) ? size / BigInt(c) : size - 1n;
    }
    return "";
};
