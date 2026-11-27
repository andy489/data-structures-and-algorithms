// https://leetcode.com/problems/count-the-number-of-powerful-integers/
var numberOfPowerfulInt = function(start, finish, limit, s) {
    function pow(base, exp) {
        let r = 1n;
        const b = BigInt(base);
        for (let i = 0; i < exp; i++) {
            r *= b;
        }
        return r;
    }

    function count(n) {
        if (n <= 0n) {
            return 0n;
        }
        const t = n.toString();
        const tLen = t.length;
        const sLen = s.length;
        if (sLen > tLen) {
            return 0n;
        }
        const prefLen = tLen - sLen;
        let result = 0n;

        // Count powerful integers with fewer than tLen digits
        for (let len = sLen; len < tLen; len++) {
            const pLen = len - sLen;
            if (pLen === 0) {
                if ([...s].every(c => parseInt(c) <= limit)) {
                    result += 1n;
                }
            } else {
                result += BigInt(limit) * pow(limit + 1, pLen - 1);
            }
        }

        // Count powerful integers with exactly tLen digits that are <= n
        let tight = true;
        for (let i = 0; i < prefLen; i++) {
            const tDigit = parseInt(t[i]);
            const lo = (i === 0) ? 1 : 0;
            const hi = tight ? Math.min(tDigit - 1, limit) : limit;
            if (hi >= lo) {
                result += BigInt(hi - lo + 1) * pow(limit + 1, prefLen - i - 1);
            }
            if (!tight || tDigit > limit) {
                tight = false;
                break;
            }
        }

        if (tight) {
            const candidate = BigInt(t.slice(0, prefLen) + s);
            if (candidate <= n) {
                result += 1n;
            }
        }

        return result;
    }

    return Number(count(BigInt(finish)) - count(BigInt(start) - 1n));
};
