// https://leetcode.com/problems/smallest-divisible-digit-product-ii/

// Solution: Prime Factorization + Greedy Digit Construction
var smallestNumber = function(num, t) {
    // Contribution of each digit (1-9) to prime factors [2, 3, 5, 7]
    const CONTRIB = [
        [0,0,0,0], // 0 unused
        [0,0,0,0], // 1
        [1,0,0,0], // 2
        [0,1,0,0], // 3
        [2,0,0,0], // 4
        [0,0,1,0], // 5
        [1,1,0,0], // 6
        [0,0,0,1], // 7
        [3,0,0,0], // 8
        [0,2,0,0]  // 9
    ];

    // Factorize t using BigInt for safety
    let rem = BigInt(t);
    const primes = [2n, 3n, 5n, 7n];
    const need = [0, 0, 0, 0];
    for (let i = 0; i < 4; i++) {
        while (rem % primes[i] === 0n) {
            need[i]++;
            rem /= primes[i];
        }
    }
    if (rem > 1n) return "-1";

    const n = num.length;
    const digits = num.split('').map(Number);

    // Try same length
    const res = dfs(digits, need.slice(), 0, true);
    if (res !== null) return res;

    // Try longer lengths
    for (let len = n + 1; len <= n + 50; len++) {
        const r = buildMinLen(len, need);
        if (r !== null) return r;
    }
    return "-1";

    function dfs(digits, need, pos, tight) {
        const n = digits.length;
        if (pos === n) {
            return need.every(x => x <= 0) ? "" : null;
        }
        const lo = tight ? Math.max(digits[pos], 1) : 1;
        for (let d = lo; d <= 9; d++) {
            const newNeed = need.map((x, i) => Math.max(0, x - CONTRIB[d][i]));
            const suffix = dfs(digits, newNeed, pos + 1, tight && d === digits[pos]);
            if (suffix !== null) return String(d) + suffix;
        }
        return null;
    }

    function buildMinLen(length, origNeed) {
        const need = origNeed.slice();
        const extra = [];
        while (need.some(x => x > 0)) {
            let bestD = -1, bestScore = -1, bestNeed = null;
            for (let d = 2; d <= 9; d++) {
                let score = 0;
                const after = need.map((x, i) => {
                    const red = Math.min(x, CONTRIB[d][i]);
                    score += red;
                    return x - red;
                });
                if (score > bestScore) {
                    bestScore = score;
                    bestD = d;
                    bestNeed = after;
                }
            }
            if (bestScore === 0) return null;
            extra.push(bestD);
            for (let i = 0; i < 4; i++) need[i] = bestNeed[i];
        }
        if (extra.length > length) return null;
        extra.sort((a, b) => a - b);
        return '1'.repeat(length - extra.length) + extra.join('');
    }
};
