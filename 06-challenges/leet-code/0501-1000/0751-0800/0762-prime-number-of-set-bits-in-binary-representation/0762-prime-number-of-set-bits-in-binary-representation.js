// https://leetcode.com/problems/prime-number-of-set-bits-in-binary-representation/

var countPrimeSetBits = function(left, right) {
    const primes = new Set([2, 3, 5, 7, 11, 13, 17, 19]);
    let count = 0;
    for (let n = left; n <= right; n++) {
        let bits = 0, x = n;
        while (x) { bits += x & 1; x >>= 1; }
        if (primes.has(bits)) count++;
    }
    return count;
};
