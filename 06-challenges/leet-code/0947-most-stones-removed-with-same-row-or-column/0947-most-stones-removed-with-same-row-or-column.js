// https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/

var removeStones = function(stones) {
    const parent = new Map();
    const find = x => { if (!parent.has(x)) parent.set(x, x); if (parent.get(x) !== x) parent.set(x, find(parent.get(x))); return parent.get(x); };
    const union = (x, y) => parent.set(find(x), find(y));
    for (const [x, y] of stones) union(x, y + 10001);
    return stones.length - new Set(stones.map(([x]) => find(x))).size;
};
