// https://leetcode.com/problems/simplified-fractions/

var simplifiedFractions = function(n) {
    const gcd = (a, b) => b ? gcd(b, a%b) : a;
    const res = [];
    for (let d = 2; d <= n; d++)
        for (let num = 1; num < d; num++)
            if (gcd(num, d) === 1) res.push(`${num}/${d}`);
    return res;
};
