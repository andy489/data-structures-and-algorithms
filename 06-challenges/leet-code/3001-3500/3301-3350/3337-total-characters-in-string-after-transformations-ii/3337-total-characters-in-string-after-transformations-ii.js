// https://leetcode.com/problems/total-characters-in-string-after-transformations-ii/

/**
 * @param {string} s
 * @param {number} t
 * @param {number[]} nums
 * @return {number}
 */
var lengthAfterTransformations = function(s, t, nums) {
    const MOD = 1_000_000_007n;
    const SIZE = 26;

    function matMul(A, B) {
        const C = Array.from({length: SIZE}, () => new Array(SIZE).fill(0n));
        for (let i = 0; i < SIZE; i++) {
            for (let k = 0; k < SIZE; k++) {
                if (A[i][k] === 0n) { continue; }
                for (let j = 0; j < SIZE; j++) {
                    C[i][j] = (C[i][j] + A[i][k] * B[k][j]) % MOD;
                }
            }
        }
        return C;
    }

    function matPow(M, p) {
        let result = Array.from({length: SIZE}, (_, i) =>
            Array.from({length: SIZE}, (_, j) => i === j ? 1n : 0n)
        );
        while (p > 0) {
            if (p & 1) { result = matMul(result, M); }
            M = matMul(M, M);
            p >>= 1;
        }
        return result;
    }

    // Build transformation matrix
    const M = Array.from({length: SIZE}, () => new Array(SIZE).fill(0n));
    for (let i = 0; i < SIZE; i++) {
        const cnt = nums[i];
        for (let j = 1; j <= cnt; j++) {
            M[(i + j) % SIZE][i] = (M[(i + j) % SIZE][i] + 1n) % MOD;
        }
    }

    const Mt = matPow(M, t);

    const freq = new Array(SIZE).fill(0n);
    for (const c of s) {
        freq[c.charCodeAt(0) - 97]++;
    }

    let ans = 0n;
    for (let i = 0; i < SIZE; i++) {
        let rowSum = 0n;
        for (let j = 0; j < SIZE; j++) {
            rowSum = (rowSum + Mt[i][j] * freq[j]) % MOD;
        }
        ans = (ans + rowSum) % MOD;
    }
    return Number(ans);
};
