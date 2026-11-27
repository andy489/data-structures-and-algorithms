// https://leetcode.com/problems/count-non-decreasing-arrays-with-given-digit-sums/

/**
 * @param {number[]} digitSum
 * @return {number}
 */
var countArrays = function(digitSum) {
    const MOD = 1_000_000_007n;

    function dsum(x) {
        let s = 0;
        while (x > 0) { s += x % 10; x = Math.floor(x / 10); }
        return s;
    }

    const bySum = Array.from({length: 51}, () => []);
    for (let x = 0; x <= 5000; x++) {
        const s = dsum(x);
        if (s <= 50) { bySum[s].push(x); }
    }

    function upperBound(arr, val) {
        let lo = 0, hi = arr.length;
        while (lo < hi) {
            const mid = (lo + hi) >> 1;
            if (arr[mid] <= val) { lo = mid + 1; } else { hi = mid; }
        }
        return lo;
    }

    let cur = bySum[digitSum[0]];
    let dp = new Array(cur.length).fill(1n);

    for (let i = 1; i < digitSum.length; i++) {
        const prev = cur, prevDp = dp;
        const prefix = new Array(prev.length + 1).fill(0n);
        for (let j = 0; j < prev.length; j++) {
            prefix[j + 1] = (prefix[j] + prevDp[j]) % MOD;
        }
        cur = bySum[digitSum[i]];
        dp = new Array(cur.length).fill(0n);
        for (let j = 0; j < cur.length; j++) {
            const idx = upperBound(prev, cur[j]);
            dp[j] = prefix[idx];
        }
    }

    let ans = 0n;
    for (const v of dp) { ans = (ans + v) % MOD; }
    return Number(ans);
};
