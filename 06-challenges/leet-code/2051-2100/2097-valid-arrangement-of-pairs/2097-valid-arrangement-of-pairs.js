// https://leetcode.com/problems/valid-arrangement-of-pairs/

// Solution: Eulerian Path (Hierholzer) — O(n) time, O(n) space
var validArrangement = function(pairs) {
    const graph = new Map(), outDeg = new Map(), inDeg = new Map();
    for (const [s, e] of pairs) {
        if (!graph.has(s)) graph.set(s, []);
        graph.get(s).push(e);
        outDeg.set(s, (outDeg.get(s) || 0) + 1);
        inDeg.set(e, (inDeg.get(e) || 0) + 1);
    }
    let start = pairs[0][0];
    for (const [node, out] of outDeg) {
        if (out - (inDeg.get(node) || 0) === 1) { start = node; break; }
    }
    const path = [], stack = [start];
    while (stack.length) {
        const u = stack[stack.length-1];
        const nb = graph.get(u);
        if (nb && nb.length) stack.push(nb.shift());
        else path.push(stack.pop());
    }
    path.reverse();
    return path.slice(0, -1).map((v, i) => [v, path[i+1]]);
};
