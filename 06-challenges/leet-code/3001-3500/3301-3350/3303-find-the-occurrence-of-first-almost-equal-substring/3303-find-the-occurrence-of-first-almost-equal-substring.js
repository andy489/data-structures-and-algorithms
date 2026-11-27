// https://leetcode.com/problems/find-the-occurrence-of-first-almost-equal-substring/

/**
 * @param {string} s
 * @param {string} pattern
 * @return {number}
 */
var minStartingIndex = function (s, pattern) {
    function zFunction(t) {
        const n = t.length;
        const z = new Array(n).fill(0);
        z[0] = n;
        let l = 0, r = 0;
        for (let i = 1; i < n; i++) {
            if (i < r) {
                z[i] = Math.min(r - i, z[i - l]);
            }
            while (i + z[i] < n && t[z[i]] === t[i + z[i]]) {
                z[i]++;
            }
            if (i + z[i] > r) {
                l = i;
                r = i + z[i];
            }
        }
        return z;
    }

    const n = s.length, m = pattern.length;
    const zPre = zFunction(pattern + "#" + s);
    const sRev = s.split("").reverse().join("");
    const pRev = pattern.split("").reverse().join("");
    const zSuf = zFunction(pRev + "#" + sRev);

    for (let i = 0; i <= n - m; i++) {
        const pre = Math.min(zPre[m + 1 + i], m);
        const suf = Math.min(zSuf[m + 1 + (n - m - i)], m);
        if (pre + suf >= m - 1) {
            return i;
        }
    }
    return -1;
};
