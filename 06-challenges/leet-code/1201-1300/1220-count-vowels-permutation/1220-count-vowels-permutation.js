// https://leetcode.com/problems/count-vowels-permutation/

var countVowelPermutation = function(n) {
    const MOD = 1000000007n;
    let a = 1n, e = 1n, i = 1n, o = 1n, u = 1n;
    for (let k = 1; k < n; k++) {
        [a, e, i, o, u] = [(e+i+u)%MOD, (a+i)%MOD, (e+o)%MOD, i%MOD, (i+o)%MOD];
    }
    return Number((a+e+i+o+u) % MOD);
};
