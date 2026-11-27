// https://leetcode.com/problems/concatenation-of-consecutive-binary-numbers/

var concatenatedBinary = function(n) {
    const MOD = BigInt(1e9 + 7);
    let result = 0n;
    let len = 0;
    for (let i = 1; i <= n; i++) {
        if ((i & (i - 1)) === 0) {
            len++;
        }
        result = ((result << BigInt(len)) | BigInt(i)) % MOD;
    }
    return Number(result);
};
