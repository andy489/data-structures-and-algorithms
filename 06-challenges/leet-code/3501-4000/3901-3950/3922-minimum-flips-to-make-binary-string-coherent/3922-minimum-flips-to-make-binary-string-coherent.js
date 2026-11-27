// https://leetcode.com/problems/minimum-flips-to-make-binary-string-coherent/

/**
 * @param {string} s
 * @return {number}
 */
var minFlips = function(s) {
    const n = s.length;
    const prefix0 = new Array(n + 1).fill(0);
    for (let i = 0; i < n; i++) {
        prefix0[i + 1] = prefix0[i] + (s[i] === '0' ? 1 : 0);
    }
    const suffix1 = new Array(n + 1).fill(0);
    for (let i = n - 1; i >= 0; i--) {
        suffix1[i] = suffix1[i + 1] + (s[i] === '1' ? 1 : 0);
    }
    let ans = n;
    for (let i = 0; i <= n; i++) {
        ans = Math.min(ans, prefix0[i] + suffix1[i]);
    }
    return ans;
};
