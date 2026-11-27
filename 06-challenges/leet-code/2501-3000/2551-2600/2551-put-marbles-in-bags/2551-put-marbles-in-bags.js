// https://leetcode.com/problems/put-marbles-in-bags/

// Solution: Sort Adjacent Pair Sums — O(n log n) time, O(n) space
var putMarbles = function(weights, k) {
    const n = weights.length;
    const pairSums = [];
    for (let i = 0; i < n - 1; i++) {
        pairSums.push(weights[i] + weights[i + 1]);
    }
    pairSums.sort((a, b) => a - b);
    let diff = 0n;
    for (let i = 0; i < k - 1; i++) {
        diff += BigInt(pairSums[n - 2 - i]) - BigInt(pairSums[i]);
    }
    return Number(diff);
};
