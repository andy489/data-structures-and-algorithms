// https://leetcode.com/problems/number-of-strings-which-can-be-rearranged-to-contain-substring/

var stringCount = function(n) {
    const MOD = 1000000007n;
    const bn = BigInt(n);

    function pw(base, exp) {
        let result = 1n;
        let b = BigInt(base) % MOD;
        let e = BigInt(exp);
        while (e > 0n) {
            if (e & 1n) result = result * b % MOD;
            b = b * b % MOD;
            e >>= 1n;
        }
        return result;
    }

    const a = pw(25, n);
    const b = (pw(25, n) + bn * pw(25, n - 1)) % MOD;
    const c = pw(25, n);
    const ab = (pw(24, n) + bn * pw(24, n - 1)) % MOD;
    const ac = pw(24, n);
    const bc = (pw(24, n) + bn * pw(24, n - 1)) % MOD;
    const abc = (pw(23, n) + bn * pw(23, n - 1)) % MOD;
    const bad = (a + b + c - ab - ac - bc + abc + 3n * MOD) % MOD;
    return Number((pw(26, n) - bad + MOD) % MOD);
};
