// https://leetcode.com/problems/minimum-operations-to-exceed-threshold-value-ii/

var minOperations = function(nums, k) {
    // Min-heap via sorted array simulation for small n; use proper heap for large n
    const pq = [...nums].map(BigInt);
    pq.sort((a,b) => (a < b ? -1 : a > b ? 1 : 0));
    let ops = 0;
    while (pq[0] < BigInt(k)) {
        pq.sort((a,b) => (a < b ? -1 : a > b ? 1 : 0));
        const x = pq.shift(), y = pq.shift();
        pq.push(x * 2n + y);
        ops++;
    }
    return ops;
};
