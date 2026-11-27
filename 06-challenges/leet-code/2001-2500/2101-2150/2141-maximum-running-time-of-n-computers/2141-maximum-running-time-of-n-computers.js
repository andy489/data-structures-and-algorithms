// https://leetcode.com/problems/maximum-running-time-of-n-computers/
var maxRunTime = function(n, batteries) {
    const canRun = (t) => {
        let large = 0, extra = 0;
        for (const b of batteries) {
            if (b >= t) {
                large++;
            } else {
                extra += b;
            }
        }
        if (large >= n) return true;
        return extra >= (n - large) * t;
    };

    let lo = 0n, hi = BigInt(batteries.reduce((a, b) => a + b, 0)) / BigInt(n);
    while (lo < hi) {
        const mid = (lo + hi + 1n) / 2n;
        if (canRun(mid)) {
            lo = mid;
        } else {
            hi = mid - 1n;
        }
    }
    return Number(lo);
};
