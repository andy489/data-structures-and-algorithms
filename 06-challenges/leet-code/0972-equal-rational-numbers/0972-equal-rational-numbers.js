// https://leetcode.com/problems/equal-rational-numbers/

var isRationalEqual = function(s, t) {
    const gcd = (a, b) => b === 0n ? a : gcd(b, a % b);
    const reduce = (n, d) => { const g = gcd(n < 0n ? -n : n, d); return [n/g, d/g]; };
    const toFrac = (x) => {
        const dot = x.indexOf('.');
        const lp = x.indexOf('(');
        if (dot === -1) return [BigInt(x), 1n];
        const intPart = BigInt(x.slice(0, dot));
        const nonRep = lp === -1 ? x.slice(dot+1) : x.slice(dot+1, lp);
        const scale = 10n ** BigInt(nonRep.length);
        const nonRepNum = nonRep ? BigInt(nonRep) : 0n;
        if (lp === -1) return reduce(intPart * scale + nonRepNum, scale);
        const rep = x.slice(lp+1, -1);
        const repDen = 10n ** BigInt(rep.length) - 1n;
        const num = intPart * scale * repDen + nonRepNum * repDen + BigInt(rep);
        return reduce(num, scale * repDen);
    };
    const [n1, d1] = toFrac(s), [n2, d2] = toFrac(t);
    return n1 === n2 && d1 === d2;
};
