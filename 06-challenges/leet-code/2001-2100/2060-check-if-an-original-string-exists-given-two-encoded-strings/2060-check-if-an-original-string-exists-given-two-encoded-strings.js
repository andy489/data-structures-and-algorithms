// https://leetcode.com/problems/check-if-an-original-string-exists-given-two-encoded-strings/

// Solution: DP with Offset Tracking — O(m*n*K) time, O(m*n*K) space
var possiblyEquals = function(s1, s2) {
    const tok = (s) => {
        const res = []; let i = 0;
        while (i < s.length) {
            if (/\d/.test(s[i])) {
                let j = i;
                while (j < s.length && /\d/.test(s[j])) j++;
                res.push(parseInt(s.slice(i, j))); i = j;
            } else { res.push(s[i++]); }
        }
        return res;
    };
    const t1 = tok(s1), t2 = tok(s2);
    const memo = new Map();
    const dp = (i, j, diff) => {
        const key = i + ',' + j + ',' + diff;
        if (memo.has(key)) return memo.get(key);
        if (i === t1.length && j === t2.length) return diff === 0;
        let res = false;
        if (i < t1.length && typeof t1[i] === 'number') res = dp(i+1, j, diff+t1[i]);
        else if (j < t2.length && typeof t2[j] === 'number') res = dp(i, j+1, diff-t2[j]);
        else if (diff > 0 && i < t1.length) res = dp(i+1, j, diff-1);
        else if (diff < 0 && j < t2.length) res = dp(i, j+1, diff+1);
        else if (diff === 0 && i < t1.length && j < t2.length && t1[i] === t2[j]) res = dp(i+1, j+1, 0);
        memo.set(key, res);
        return res;
    };
    return dp(0, 0, 0);
};
