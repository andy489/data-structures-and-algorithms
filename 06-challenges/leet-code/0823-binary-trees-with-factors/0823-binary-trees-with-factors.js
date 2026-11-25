// https://leetcode.com/problems/binary-trees-with-factors/

var numFactoredBinaryTrees = function(arr) {
    const MOD = 1e9 + 7;
    arr.sort((a, b) => a - b);
    const dp = new Map();
    for (const x of arr) { dp.set(x, 1); }
    for (let i = 0; i < arr.length; i++) {
        for (let j = 0; j < i; j++) {
            if (arr[i] % arr[j] === 0) {
                const right = arr[i] / arr[j];
                if (dp.has(right)) {
                    dp.set(arr[i], (dp.get(arr[i]) + dp.get(arr[j]) * dp.get(right)) % MOD);
                }
            }
        }
    }
    let total = 0;
    for (const v of dp.values()) { total = (total + v) % MOD; }
    return total;
};
