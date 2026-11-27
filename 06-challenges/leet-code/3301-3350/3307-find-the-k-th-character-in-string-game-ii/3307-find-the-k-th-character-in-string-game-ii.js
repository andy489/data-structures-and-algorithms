// https://leetcode.com/problems/find-the-k-th-character-in-string-game-ii/

/**
 * @param {number} k
 * @param {number[]} operations
 * @return {character}
 */
var kthCharacter = function (k, operations) {
    const n = operations.length;
    const sizes = new Array(n + 1).fill(0n);
    sizes[0] = 1n;
    for (let i = 0; i < n; i++) {
        sizes[i + 1] = sizes[i] * 2n > 2000000000000000n ? 2000000000000000n : sizes[i] * 2n;
    }
    let shift = 0;
    let kb = BigInt(k);
    for (let i = n - 1; i >= 0; i--) {
        const half = sizes[i];
        if (kb > half) {
            kb -= half;
            if (operations[i] === 1) {
                shift++;
            }
        }
    }
    return String.fromCharCode('a'.charCodeAt(0) + shift % 26);
};
