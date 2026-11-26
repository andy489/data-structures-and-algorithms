// https://leetcode.com/problems/count-nodes-with-the-highest-score/

// Solution: DFS Subtree Sizes — O(n) time, O(n) space
var countHighestScoreNodes = function(parents) {
    const n = parents.length;
    const children = Array.from({length: n}, () => []);
    for (let i = 1; i < n; i++) children[parents[i]].push(i);
    const size = new Array(n).fill(1);
    const stack = [[0, false]];
    while (stack.length) {
        const [u, done] = stack.pop();
        if (done) { for (const c of children[u]) size[u] += size[c]; }
        else { stack.push([u, true]); for (const c of children[u]) stack.push([c, false]); }
    }
    let maxScore = 0n, count = 0;
    for (let i = 0; i < n; i++) {
        const ch = children[i];
        const left = ch.length > 0 ? size[ch[0]] : 0;
        const right = ch.length > 1 ? size[ch[1]] : 0;
        const up = n - 1 - left - right;
        let score = 1n;
        for (const s of [left, right, up]) { if (s > 0) score *= BigInt(s); }
        if (score > maxScore) { maxScore = score; count = 1; }
        else if (score === maxScore) count++;
    }
    return count;
};
