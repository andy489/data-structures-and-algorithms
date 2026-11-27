// https://leetcode.com/problems/super-pow/

// Solution: Modular Exponentiation — O(n) time, O(1) space
var superPow = function(a, b) {
    const MOD = 1337;
    const powMod = (base, exp) => {
        base %= MOD;
        let res = 1;
        while (exp > 0) {
            if (exp & 1) res = res * base % MOD;
            base = base * base % MOD;
            exp >>= 1;
        }
        return res;
    };
    let result = 1;
    for (const d of b) {
        result = powMod(result, 10) * powMod(a, d) % MOD;
    }
    return result;
};
