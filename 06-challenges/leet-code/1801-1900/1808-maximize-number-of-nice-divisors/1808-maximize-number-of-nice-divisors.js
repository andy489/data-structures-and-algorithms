// https://leetcode.com/problems/maximize-number-of-nice-divisors/

var maxNiceDivisors = function(primeFactors) {
    const MOD = 1000000007n;
    if (primeFactors <= 3) {
        return primeFactors;
    }

    function power(base, exp, mod) {
        let result = 1n;
        base = base % mod;
        while (exp > 0n) {
            if (exp & 1n) {
                result = result * base % mod;
            }
            base = base * base % mod;
            exp >>= 1n;
        }
        return result;
    }

    const rem = primeFactors % 3;
    const threes = BigInt(Math.floor(primeFactors / 3));
    if (rem === 0) {
        return Number(power(3n, threes, MOD));
    }
    if (rem === 1) {
        return Number(power(3n, threes - 1n, MOD) * 4n % MOD);
    }
    return Number(power(3n, threes, MOD) * 2n % MOD);
};
