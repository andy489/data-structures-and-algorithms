// https://leetcode.com/problems/minimum-number-of-operations-to-reinitialize-a-permutation/

var reinitializePermutation = function(n) {
    let perm = Array.from({length: n}, (_, i) => i);
    const orig = Array.from({length: n}, (_, i) => i);
    let ops = 0;
    do {
        const arr = new Array(n);
        for (let i = 0; i < n; i++) {
            arr[i] = i % 2 === 0 ? perm[i / 2] : perm[n / 2 + (i - 1) / 2];
        }
        perm = arr;
        ops++;
    } while (!perm.every((v, i) => v === orig[i]));
    return ops;
};
