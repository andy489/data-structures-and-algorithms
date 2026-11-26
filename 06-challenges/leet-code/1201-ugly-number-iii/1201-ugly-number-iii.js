// https://leetcode.com/problems/ugly-number-iii/

var nthUglyNumber = function(n, a, b) {
    const gcd = (x, y) => y === 0 ? x : gcd(y, x % y);
    const lcm = BigInt(a) * BigInt(b) / BigInt(gcd(a, b));
    let lo = 1n, hi = BigInt(n) * BigInt(Math.min(a, b));
    while (lo < hi) {
        const mid = (lo + hi) / 2n;
        if (mid / BigInt(a) + mid / BigInt(b) - mid / lcm >= BigInt(n)) hi = mid;
        else lo = mid + 1n;
    }
    return Number(lo);
};
