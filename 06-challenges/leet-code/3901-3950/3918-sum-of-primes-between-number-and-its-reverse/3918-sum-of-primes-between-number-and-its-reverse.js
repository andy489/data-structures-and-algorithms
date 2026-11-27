// https://leetcode.com/problems/sum-of-primes-between-number-and-its-reverse/
/**
 * @param {number} n
 * @return {number}
 */
var sumOfPrimes = function(n) {
    const r = parseInt(n.toString().split('').reverse().join(''));
    const lo = Math.min(n, r), hi = Math.max(n, r);
    if (hi < 2) { return 0; }
    const sieve = new Uint8Array(hi + 1).fill(1);
    sieve[0] = sieve[1] = 0;
    for (let i = 2; i * i <= hi; i++) {
        if (sieve[i]) {
            for (let j = i * i; j <= hi; j += i) {
                sieve[j] = 0;
            }
        }
    }
    let sum = 0;
    for (let i = lo; i <= hi; i++) {
        if (sieve[i]) { sum += i; }
    }
    return sum;
};
