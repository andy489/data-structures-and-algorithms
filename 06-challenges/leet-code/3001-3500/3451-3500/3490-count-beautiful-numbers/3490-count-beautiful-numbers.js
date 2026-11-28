// https://leetcode.com/problems/count-beautiful-numbers/

var beautifulNumbers = function(l, r) {
    const MOD = 2520; // LCM(1..9)

    const countUpTo = (n) => {
        if (n <= 0) return 0;
        const digits = String(n).split('').map(Number);
        const len = digits.length;
        const cache = new Map();

        const dp = (pos, sum, prod, tight) => {
            if (pos === len) {
                if (sum === 0) return 0;
                return prod % sum === 0 ? 1 : 0;
            }
            const key = `${pos},${sum},${prod},${tight}`;
            if (!tight && cache.has(key)) return cache.get(key);
            const limit = tight ? digits[pos] : 9;
            let result = 0;
            for (let d = 0; d <= limit; d++) {
                if (sum === 0 && d === 0) {
                    result += dp(pos + 1, 0, 0, tight && d === limit);
                } else {
                    const ns = sum + d;
                    const np = sum === 0 ? d : (prod * d) % MOD;
                    result += dp(pos + 1, ns, np, tight && d === limit);
                }
            }
            if (!tight) cache.set(key, result);
            return result;
        };

        return dp(0, 0, 0, true);
    };

    return countUpTo(r) - countUpTo(l - 1);
};
