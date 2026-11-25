// https://leetcode.com/problems/3sum-with-multiplicity/

var threeSumMulti = function(arr, target) {
    const MOD = 1e9 + 7;
    const count = new Array(101).fill(0);
    for (const x of arr) count[x]++;
    let result = 0;
    for (let i = 0; i <= 100; i++) {
        for (let j = i; j <= 100; j++) {
            const k = target - i - j;
            if (k < j || k > 100) continue;
            if (i === j && j === k) result += count[i] * (count[i]-1) * (count[i]-2) / 6;
            else if (i === j)       result += count[i] * (count[i]-1) / 2 * count[k];
            else if (j === k)       result += count[i] * count[j] * (count[j]-1) / 2;
            else                    result += count[i] * count[j] * count[k];
        }
    }
    return result % MOD;
};
