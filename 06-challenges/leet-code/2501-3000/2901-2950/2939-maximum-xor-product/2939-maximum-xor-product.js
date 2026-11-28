// https://leetcode.com/problems/maximum-xor-product/

var maximumXorProduct = function(a, b, n) {
    const MOD = 1000000007n;
    a = BigInt(a);
    b = BigInt(b);
    for (let i = n - 1; i >= 0; i--) {
        const bitA = (a >> BigInt(i)) & 1n;
        const bitB = (b >> BigInt(i)) & 1n;
        if (bitA === bitB) {
            a |= (1n << BigInt(i));
            b |= (1n << BigInt(i));
        } else {
            if (a < b) {
                a |= (1n << BigInt(i));
                b &= ~(1n << BigInt(i));
            } else {
                b |= (1n << BigInt(i));
                a &= ~(1n << BigInt(i));
            }
        }
    }
    return Number((a % MOD) * (b % MOD) % MOD);
};
