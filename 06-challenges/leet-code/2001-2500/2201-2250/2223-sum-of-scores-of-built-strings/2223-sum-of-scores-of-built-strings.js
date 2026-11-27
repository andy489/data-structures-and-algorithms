// https://leetcode.com/problems/sum-of-scores-of-built-strings/
var sumScores = function (s) {
    const n = s.length;
    const z = new Array(n).fill(0);
    let l = 0, r = 0;
    for (let i = 1; i < n; i++) {
        if (i < r) {
            z[i] = Math.min(r - i, z[i - l]);
        }
        while (i + z[i] < n && s[z[i]] === s[i + z[i]]) {
            z[i]++;
        }
        if (i + z[i] > r) {
            l = i;
            r = i + z[i];
        }
    }
    let sum = BigInt(n);
    for (let i = 1; i < n; i++) {
        sum += BigInt(z[i]);
    }
    return sum;
};
