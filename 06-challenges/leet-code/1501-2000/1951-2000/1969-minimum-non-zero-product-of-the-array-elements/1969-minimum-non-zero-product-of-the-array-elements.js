// https://leetcode.com/problems/minimum-non-zero-product-of-the-array-elements/
var minNonZeroProduct = function(p) {
    const MOD = BigInt(1e9 + 7);
    const maxVal = (1n << BigInt(p)) - 1n;
    const pairVal = maxVal - 1n;
    const pairCount = (maxVal - 1n) / 2n;
    return Number((maxVal % MOD) * powMod(pairVal % MOD, pairCount, MOD) % MOD);
};

function powMod(base, exp, mod) {
    let result = 1n;
    base = base % mod;
    while (exp > 0n) {
        if (exp & 1n) {
            result = result * base % mod;
        }
        base = base * base % mod;
        exp >>= 1n;
    }
    return result;
}
