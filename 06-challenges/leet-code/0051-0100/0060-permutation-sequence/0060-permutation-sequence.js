// https://leetcode.com/problems/permutation-sequence/

var getPermutation = function(n, k) {
    const fact = new Array(n).fill(1);
    for (let i = 1; i < n; i++) {
        fact[i] = fact[i - 1] * i;
    }
    const digits = Array.from({length: n}, (_, i) => i + 1);
    k--;
    let result = '';
    for (let i = n - 1; i >= 0; i--) {
        const idx = Math.floor(k / fact[i]);
        result += digits[idx];
        digits.splice(idx, 1);
        k %= fact[i];
    }
    return result;
};
