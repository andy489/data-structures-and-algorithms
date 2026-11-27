// https://leetcode.com/problems/nth-magical-number/

var nthMagicalNumber = function(n, a, b) {
    const MOD = 1000000007n;
    const gcd = (x, y) => y === 0n ? x : gcd(y, x % y);
    const [A, B, N] = [BigInt(a), BigInt(b), BigInt(n)];
    const lcm = A * B / gcd(A, B);
    let lo = 1n, hi = N * (A < B ? A : B);
    while (lo < hi) {
        const mid = (lo + hi) / 2n;
        if (mid / A + mid / B - mid / lcm >= N) hi = mid;
        else lo = mid + 1n;
    }
    return Number(lo % MOD);
};
