// https://leetcode.com/problems/minimum-number-of-vertices-to-reach-all-nodes/

var findSmallestSetOfVertices = function(n, edges) {
    const hasIncoming = new Set(edges.map(e => e[1]));
    const result = [];
    for (let i = 0; i < n; i++) {
        if (!hasIncoming.has(i)) {
            result.push(i);
        }
    }
    return result;
};
