// https://leetcode.com/problems/rearranging-fruits/

// Solution: Frequency Counting + Greedy — O(n log n) time, O(n) space
var minCost = function(basket1, basket2) {
    const count = new Map();
    for (const x of basket1) {
        count.set(x, (count.get(x) || 0) + 1);
    }
    for (const x of basket2) {
        count.set(x, (count.get(x) || 0) - 1);
    }
    const globalMin = Math.min(...basket1, ...basket2);
    const extra = [];
    for (const [val, diff] of count) {
        if (diff % 2 !== 0) {
            return -1;
        }
        for (let i = 0; i < Math.abs(diff) / 2; i++) {
            extra.push(val);
        }
    }
    extra.sort((a, b) => a - b);
    const m = extra.length;
    let cost = 0;
    for (let i = 0; i < Math.floor(m / 2); i++) {
        cost += Math.min(extra[i], 2 * globalMin);
    }
    return cost;
};
