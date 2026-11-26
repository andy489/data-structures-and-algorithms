// https://leetcode.com/problems/number-of-sub-arrays-with-odd-sum/

var numOfSubarrays = function(arr) {
    const MOD = 1_000_000_007n;
    let result = 0n, even = 1, odd = 0, prefix = 0;
    for (const x of arr) {
        prefix += x;
        if (prefix & 1) {
            result += BigInt(even);
            odd++;
        } else {
            result += BigInt(odd);
            even++;
        }
    }
    return Number(result % MOD);
};
