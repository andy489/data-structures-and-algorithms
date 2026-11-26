// https://leetcode.com/problems/number-of-ways-to-reorder-array-to-get-same-bst/

var numOfWays = function(nums) {
    const MOD = 1_000_000_007n;
    const n = nums.length;
    const C = Array.from({length: n + 1}, () => new Array(n + 1).fill(0n));
    for (let i = 0; i <= n; i++) {
        C[i][0] = 1n;
        for (let j = 1; j <= i; j++) {
            C[i][j] = (C[i - 1][j - 1] + C[i - 1][j]) % MOD;
        }
    }

    const count = (arr) => {
        if (arr.length <= 2) {
            return 1n;
        }
        const root = arr[0];
        const left = arr.slice(1).filter(x => x < root);
        const right = arr.slice(1).filter(x => x > root);
        return C[left.length + right.length][left.length] * count(left) % MOD * count(right) % MOD;
    };

    return Number((count(nums) - 1n + MOD) % MOD);
};
