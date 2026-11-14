// https://leetcode.com/problems/count-primes/

// Solution 1: Sieve of Eratosthenes
var countPrimes = function(n) {
    if (n < 2) return 0;
    const isComposite = new Uint8Array(n);
    for (let i = 2; i * i < n; i++) {
        if (!isComposite[i]) {
            for (let j = i * i; j < n; j += i) {
                isComposite[j] = 1;
            }
        }
    }
    let count = 0;
    for (let i = 2; i < n; i++) {
        if (!isComposite[i]) count++;
    }
    return count;
};

// Solution 2: Linear Sieve (Sieve of Euler)
var countPrimes2 = function(n) {
    if (n < 2) return 0;
    const isComposite = new Uint8Array(n);
    const primes = [];
    for (let i = 2; i < n; i++) {
        if (!isComposite[i]) primes.push(i);
        for (const p of primes) {
            if (i * p >= n) break;
            isComposite[i * p] = 1;
            if (i % p === 0) break;
        }
    }
    return primes.length;
};

// Solution 3: Segmented Sieve
var countPrimes3 = function(n) {
    if (n < 2) return 0;
    const limit = Math.floor(Math.sqrt(n));
    const isComposite = new Uint8Array(limit + 1);
    const smallPrimes = [];
    for (let i = 2; i <= limit; i++) {
        if (!isComposite[i]) {
            smallPrimes.push(i);
            for (let j = i * i; j <= limit; j += i) isComposite[j] = 1;
        }
    }
    let count = 0;
    for (let low = 2; low < n; low += limit) {
        const high = Math.min(low + limit, n);
        const block = new Uint8Array(high - low);
        for (const p of smallPrimes) {
            const start = Math.max(p * p, Math.ceil(low / p) * p);
            for (let j = start; j < high; j += p) block[j - low] = 1;
        }
        for (let i = 0; i < block.length; i++) {
            if (!block[i]) count++;
        }
    }
    return count;
};

