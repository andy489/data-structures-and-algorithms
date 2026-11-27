// https://leetcode.com/problems/prime-arrangements/

function isPrime(n) {
    if (n < 2) {
        return false;
    }
    for (let i = 2; i * i <= n; i++) {
        if (n % i === 0) {
            return false;
        }
    }
    return true;
}

var numPrimeArrangements = function(n) {
    const MOD = 1_000_000_007n;
    let primes = 0;
    for (let i = 1; i <= n; i++) {
        if (isPrime(i)) {
            primes++;
        }
    }
    const nonPrimes = n - primes;
    let result = 1n;
    for (let i = 1; i <= primes; i++) {
        result = result * BigInt(i) % MOD;
    }
    for (let i = 1; i <= nonPrimes; i++) {
        result = result * BigInt(i) % MOD;
    }
    return Number(result);
};
