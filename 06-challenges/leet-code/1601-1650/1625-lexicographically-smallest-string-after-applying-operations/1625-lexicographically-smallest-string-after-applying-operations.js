// https://leetcode.com/problems/lexicographically-smallest-string-after-applying-operations/

var findLexSmallestString = function(s, a, b) {
    const visited = new Set([s]);
    const q = [s];
    let ans = s;
    for (let qi = 0; qi < q.length; qi++) {
        const cur = q[qi];
        if (cur < ans) ans = cur;
        const ch = cur.split('');
        for (let i = 1; i < ch.length; i += 2) {
            ch[i] = String((+ch[i] + a) % 10);
        }
        const added = ch.join('');
        const n = cur.length;
        const rotated = cur.slice(n - b) + cur.slice(0, n - b);
        for (const nxt of [added, rotated]) {
            if (!visited.has(nxt)) {
                visited.add(nxt);
                q.push(nxt);
            }
        }
    }
    return ans;
};
