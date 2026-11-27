// https://leetcode.com/problems/maximum-number-of-items-from-sale-ii/
/**
 * @param {number[][]} items
 * @param {number} budget
 * @return {number}
 */
var maxItems = function(items, budget) {
    const n = items.length;
    const freeCount = new Array(n).fill(0);
    const byFactor = new Map();
    for (let i = 0; i < n; i++) {
        const f = items[i][0];
        if (!byFactor.has(f)) {
            byFactor.set(f, []);
        }
        byFactor.get(f).push(i);
    }
    for (let i = 0; i < n; i++) {
        const fi = items[i][0];
        for (let mult = fi; mult <= n; mult += fi) {
            if (byFactor.has(mult)) {
                freeCount[i] += byFactor.get(mult).length;
            }
        }
        freeCount[i]--; // exclude self
    }

    let minPrice = Infinity;
    for (const [, price] of items) {
        minPrice = Math.min(minPrice, price);
    }

    const order = Array.from({length: n}, (_, i) => i);
    order.sort((a, b) => {
        const ra = (1 + freeCount[a]) / items[a][1];
        const rb = (1 + freeCount[b]) / items[b][1];
        return rb - ra;
    });

    let total = 0;
    let remaining = budget;
    for (const i of order) {
        const price = items[i][1];
        if (price <= remaining) {
            remaining -= price;
            total += 1 + freeCount[i];
        }
    }
    total += Math.floor(remaining / minPrice);
    return total;
};
