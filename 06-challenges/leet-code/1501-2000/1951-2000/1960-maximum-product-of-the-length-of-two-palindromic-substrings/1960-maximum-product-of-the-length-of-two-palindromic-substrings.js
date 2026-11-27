// https://leetcode.com/problems/maximum-product-of-the-length-of-two-palindromic-substrings/
var maxProduct = function(s) {
    const n = s.length;
    const p = manacher(s);

    const left = new Array(n).fill(1);
    for (let i = 0; i < n; i++) {
        const r = p[i];
        const end = i + r;
        if (end < n) {
            left[end] = Math.max(left[end], 2 * r + 1);
        }
    }
    for (let i = 1; i < n; i++) {
        left[i] = Math.max(left[i], left[i - 1]);
    }

    const right = new Array(n).fill(1);
    for (let i = 0; i < n; i++) {
        const r = p[i];
        const start = i - r;
        right[start] = Math.max(right[start], 2 * r + 1);
    }
    for (let i = n - 2; i >= 0; i--) {
        right[i] = Math.max(right[i], right[i + 1]);
    }

    let ans = 0;
    for (let i = 0; i < n - 1; i++) {
        ans = Math.max(ans, left[i] * right[i + 1]);
    }
    return ans;
};

function manacher(s) {
    const n = s.length;
    const p = new Array(n).fill(0);
    let c = 0, r = 0;
    for (let i = 0; i < n; i++) {
        if (i < r) {
            p[i] = Math.min(r - i, p[2 * c - i]);
        }
        while (i - p[i] - 1 >= 0 && i + p[i] + 1 < n
                && s[i - p[i] - 1] === s[i + p[i] + 1]) {
            p[i]++;
        }
        if (i + p[i] > r) {
            c = i;
            r = i + p[i];
        }
    }
    return p;
}
