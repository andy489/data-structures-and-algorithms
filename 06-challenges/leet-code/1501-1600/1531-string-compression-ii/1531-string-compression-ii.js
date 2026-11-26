// https://leetcode.com/problems/string-compression-ii/

var getLengthOfOptimalCompression = function(s, k) {
    const n = s.length;
    const memo = new Map();

    function runLen(cnt) {
        if (cnt === 1) return 1;
        if (cnt < 10) return 2;
        if (cnt < 100) return 3;
        return 4;
    }

    function dp(i, last, lastCnt, rem) {
        if (rem < 0) return Infinity;
        if (i === n) return 0;
        const key = `${i},${last},${lastCnt},${rem}`;
        if (memo.has(key)) return memo.get(key);
        const del = dp(i + 1, last, lastCnt, rem - 1);
        let keep;
        if (s[i] === last) {
            keep = dp(i + 1, last, lastCnt + 1, rem) + ([1, 9, 99].includes(lastCnt) ? 1 : 0);
        } else {
            keep = dp(i + 1, s[i], 1, rem) + 1;
        }
        const res = Math.min(del, keep);
        memo.set(key, res);
        return res;
    }

    return dp(0, '', 0, k);
};
