// https://leetcode.com/problems/subsequence-with-the-minimum-score/

// Solution: Prefix + Suffix Matching — O(n+m) time, O(n+m) space
var minimumScore = function(s, t) {
    const n = s.length, m = t.length;

    // pre[i] = number of t chars matched using s[0..i] (prefix of t)
    const pre = new Array(n).fill(0);
    let j = 0;
    for (let i = 0; i < n; i++) {
        if (j < m && s[i] === t[j]) {
            j++;
        }
        pre[i] = j;
    }

    // suf[i] = number of t chars matched using s[i..n-1] (suffix of t)
    const suf = new Array(n).fill(0);
    j = m - 1;
    for (let i = n - 1; i >= 0; i--) {
        if (j >= 0 && s[i] === t[j]) {
            j--;
        }
        suf[i] = m - 1 - j;
    }

    if (pre[n - 1] === m) {
        return 0;
    }

    let ans = m;
    for (let i = -1; i < n; i++) {
        const prefixMatched = i >= 0 ? pre[i] : 0;
        const suffixMatched = i + 1 < n ? suf[i + 1] : 0;
        const removed = m - prefixMatched - suffixMatched;
        ans = Math.min(ans, Math.max(0, removed));
    }
    return ans;
};
