// https://leetcode.com/problems/find-building-where-alice-and-bob-can-meet/

var leftmostBuildingQueries = function(heights, queries) {
    const n = heights.length;
    const q = queries.length;
    const ans = new Array(q).fill(-1);
    const buckets = Array.from({length: n}, () => []);

    for (let i = 0; i < q; i++) {
        let [a, b] = queries[i];
        if (a > b) { [a, b] = [b, a]; }
        if (a === b || heights[a] < heights[b]) {
            ans[i] = b;
        } else {
            buckets[b].push([Math.max(heights[a], heights[b]), i]);
        }
    }

    // Min-heap via sorted array (simple for JS; for large input use a proper heap)
    const heap = [];
    const push = (val) => { heap.push(val); heap.sort((x, y) => x[0] - y[0]); };
    const pop = () => heap.shift();

    for (let i = 0; i < n; i++) {
        for (const entry of buckets[i]) { push(entry); }
        while (heap.length && heap[0][0] < heights[i]) {
            const [, qi] = pop();
            ans[qi] = i;
        }
    }

    return ans;
};
