// https://leetcode.com/problems/permutations-iv/

var permute = function(n, k) {
    const oddTotal = Math.floor((n + 1) / 2);
    const evenTotal = Math.floor(n / 2);

    // count(o, e, last): alternating perms with o odds and e evens left
    // last: 0 = last odd, 1 = last even, -1 = start
    const memo = new Map();
    function count(o, e, last) {
        if (o === 0 && e === 0) return 1n;
        const key = `${o},${e},${last}`;
        if (memo.has(key)) return memo.get(key);
        let result = 0n;
        if (last !== 0 && o > 0) result += BigInt(o) * count(o - 1, e, 0);
        if (last !== 1 && e > 0) result += BigInt(e) * count(o, e - 1, 1);
        memo.set(key, result);
        return result;
    }

    const total = count(oddTotal, evenTotal, -1);
    if (BigInt(k) > total) return [];

    let remaining = BigInt(k);
    const result = [];
    const usedOdds = new Set(), usedEvens = new Set();
    let last = -1;

    for (let pos = 0; pos < n; pos++) {
        const oLeft = oddTotal - usedOdds.size;
        const eLeft = evenTotal - usedEvens.size;
        const odds = [], evens = [];
        for (let x = 1; x <= n; x += 2) if (!usedOdds.has(x)) odds.push(x);
        for (let x = 2; x <= n; x += 2) if (!usedEvens.has(x)) evens.push(x);
        const candidates = last === 0 ? evens : last === 1 ? odds : [...odds, ...evens].sort((a, b) => a - b);

        for (const cand of candidates) {
            const isOdd = cand % 2 === 1;
            const newO = oLeft - (isOdd ? 1 : 0);
            const newE = eLeft - (isOdd ? 0 : 1);
            const newLast = isOdd ? 0 : 1;
            const ways = count(newO, newE, newLast);
            if (remaining <= ways) {
                result.push(cand);
                if (isOdd) usedOdds.add(cand); else usedEvens.add(cand);
                last = newLast;
                break;
            }
            remaining -= ways;
        }
    }
    return result;
};
