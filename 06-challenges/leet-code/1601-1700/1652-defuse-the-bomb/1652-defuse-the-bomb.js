// https://leetcode.com/problems/defuse-the-bomb/

var decrypt = function(code, k) {
    const n = code.length;
    const result = new Array(n).fill(0);
    if (k === 0) {
        return result;
    }
    const prefix = new Array(2 * n + 1).fill(0);
    for (let i = 0; i < 2 * n; i++) {
        prefix[i + 1] = prefix[i] + code[i % n];
    }
    for (let i = 0; i < n; i++) {
        let lo, hi;
        if (k > 0) {
            lo = i + 1;
            hi = i + k;
        } else {
            lo = i - (-k) + n;
            hi = i - 1 + n;
        }
        result[i] = prefix[hi + 1] - prefix[lo];
    }
    return result;
};
