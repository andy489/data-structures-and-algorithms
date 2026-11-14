// https://leetcode.com/problems/count-primes/

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
