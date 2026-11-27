// https://leetcode.com/problems/count-fancy-numbers-in-a-range/

/**
 * @param {number} l
 * @param {number} r
 * @return {number}
 */
var countFancyNumbers = function(l, r) {
    function isGood(n) {
        if (n < 10) return true;
        const s = String(n);
        let inc = true, dec = true;
        for (let i = 1; i < s.length; i++) {
            if (s[i] >= s[i-1]) inc = false;
            if (s[i] <= s[i-1]) dec = false;
        }
        return inc || dec;
    }

    function count(n) {
        if (n <= 0) return 0;
        const s = String(n);
        const digs = s.split('').map(Number);
        const len = digs.length;
        const memo = new Map();

        function dp(pos, tight, dsum, prev, inc, dec, started) {
            if (pos === len) {
                if (!started) return 0;
                return (inc || dec || isGood(dsum)) ? 1 : 0;
            }
            const key = `${pos},${tight},${dsum},${prev},${inc},${dec},${started}`;
            if (memo.has(key)) return memo.get(key);
            const limit = tight ? digs[pos] : 9;
            let res = 0;
            for (let d = 0; d <= limit; d++) {
                const nt = tight && d === limit;
                if (!started && d === 0) {
                    res += dp(pos+1, nt, 0, -1, true, true, false);
                } else {
                    const ni = started ? (inc && d > prev) : true;
                    const nd = started ? (dec && d < prev) : true;
                    res += dp(pos+1, nt, dsum+d, d, ni, nd, true);
                }
            }
            memo.set(key, res);
            return res;
        }

        return dp(0, true, 0, -1, true, true, false);
    }

    return count(r) - count(l - 1);
};
